package com.mm.controller;

import com.alibaba.fastjson.JSONObject;
import com.mm.base.BaseController;
import com.mm.domain.*;
import com.mm.service.CarService;
import com.mm.service.OrderDetailService;
import com.mm.service.OrderService;
import com.mm.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
    @Autowired
    OrderService orderService;
    @Autowired
    CarService carService;
    @Autowired
    OrderDetailService orderDetailService;

    /**
     * 结算
     * @param carDtos
     * @param request
     * @return
     */
    @RequestMapping("exadd")
    @ResponseBody
    public String exadd(@RequestBody List<CarDto> carDtos, HttpServletRequest request){
//        System.out.println("我是exadd");
//        System.out.println(carDtos);
        JSONObject js=new JSONObject();
        User loginUser= (User) request.getSession().getAttribute(Consts.USER);
        if(loginUser==null){
            js.put(Consts.RES,0);
            return js.toJSONString();
        }
        //拿出购物车的东西，通过cars
        double totals=0;
        for(CarDto carDto:carDtos){
            Car car=carService.getEntiryById(carDto.getCarId());
            double purchaseNum=carDto.getPurchaseNum();
            double carTotal=purchaseNum*car.getBookPrice();
            totals+=carTotal;
        }
        //创建订单
        Order order=new Order();
        order.setUserId(loginUser.getUserId());
        order.setOrderStatus(0);
        order.setOrderTotal(totals);
        int res=orderService.insert(order);
        //System.out.println("ID号为---------------"+order.getorderId());

//        创建订单详情
        for(CarDto carDto:carDtos){
            Car c=carService.getEntiryById(carDto.getCarId());
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setOrderStatus(order.getOrderStatus());
            orderDetail.setOrderId(order.getorderId());
            orderDetail.setOrderNum(carDto.getPurchaseNum());
            orderDetail.setOrderTotal(c.getBookPrice()*carDto.getPurchaseNum());
            orderDetail.setBookId(c.getBookId());
            orderDetailService.insert(orderDetail);

            carService.deleteById(c.getCarId());

        }


        js.put(Consts.RES,1);
        return js.toJSONString();
    }
    @RequestMapping("ex")
    public String ex(){
//        System.out.println("这是ex内部");
        return "";
    }

    @RequestMapping("my")
    public String my(Model model,HttpServletRequest request){
        User user=(User)request.getSession().getAttribute(Consts.USER);
        if(user==null){
            return "redirect:/login/uLogin";
        }
        Integer userId=user.getUserId();
        //全部订单
        String sql1="select * from orders where userId='"+userId+"' order by orderId desc";
        List<Order> all=orderService.getListEntiryBySql(sql1);
        //System.out.println(all);
        /**
         * 订单状态
         * 待发货 0
         * 已取消 1
         * 已发货 2
         * 已收获 3
         */
        //待发货
        String sql2="select * from orders where userId='"+userId+"' and orderStatus=0 order by orderId desc";
        List<Order> dfh=orderService.getListEntiryBySql(sql2);
        System.out.println(dfh);
        //已取消
        String sql3="select * from orders where userId='"+userId+"' and orderStatus=1 order by orderId desc";
        List<Order> yqx=orderService.getListEntiryBySql(sql3);

        //已发货
        String sql4="select * from orders where userId='"+userId+"' and orderStatus=2 order by orderId desc";
        List<Order> dsh=orderService.getListEntiryBySql(sql4);

        //已收获
        String sql5="select * from orders where userId='"+userId+"' and orderStatus=3 order by orderId desc";
        List<Order> ysh=orderService.getListEntiryBySql(sql5);


        model.addAttribute("all",all);
        model.addAttribute("dfh",dfh);
        model.addAttribute("yqx",yqx);
        model.addAttribute("dsh",dsh);
        model.addAttribute("ysh",ysh);

        return "order/my";

    }

    //取消订单
    @RequestMapping("qx")
    public String qx(Model model,Integer orderId){
        Order order=orderService.getEntiryById(orderId);
        order.setOrderStatus(1);
        orderService.update(order);
        return "redirect:/order/my";
    }
    //收获订单
    @RequestMapping("sh")
    public String sh(Model model,Integer orderId){
        Order order=orderService.getEntiryById(orderId);
        order.setOrderStatus(3);
        orderService.update(order);
        return "redirect:/order/my";
    }



}
