package com.mm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mm.domain.Book;
import com.mm.domain.Car;
import com.mm.domain.User;
import com.mm.service.BookService;
import com.mm.service.CarService;
import com.mm.util.Consts;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    BookService bookService;
    @Autowired
    CarService carService;


    @RequestMapping("exadd")
    @ResponseBody
    public String exadd(Car car, HttpServletRequest request){
        JSONObject js=new JSONObject();
        User loginUser= (User) request.getSession().getAttribute(Consts.USER);
        //System.out.println("购物车的东西为："+car);
        //判断非法登录
        if(loginUser== null){
            js.put(Consts.RES,0);
//            System.out.println("json的值为"+js.getClass());//json对象
//            System.out.println("toJsonString："+js.toJSONString().getClass());//json字符串
            return js.toJSONString();
        }
        Book book=bookService.getEntiryById(car.getBookId());
        DecimalFormat df=new DecimalFormat("0.00");
        double bookPrice=book.getBookPrice();
        df.format(bookPrice);
        if(car.getPurchaseNum()==null || car.getPurchaseNum()==0){
            car.setPurchaseNum(1);
        }
        double totalPrice=bookPrice*car.getPurchaseNum();
        df.format(totalPrice);

        car.setUserId(loginUser.getUserId());
        car.setBookPrice(bookPrice);
        car.setPurchaseTotal(totalPrice);

        System.out.println("购物车的东西为："+car);
        int res=carService.insert(car);
        js.put(Consts.RES,1);
        return js.toJSONString();
    }

    //展示购物车页面
    @RequestMapping("findBySql")
    public String findBySql(Model model, HttpServletRequest request){
        User loginUser= (User) request.getSession().getAttribute(Consts.USER);
        if(loginUser==null){
            return "redirect:/login/toLogin";
        }
        String sql="select * from cars where userId='"+loginUser.getUserId()+"'";
        List<Car> list=carService.getListEntiryBySql(sql);
        System.out.println(list);
        model.addAttribute("list",list);
        return "/car/car";
    }
    //删除商品
    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer carId){
        carService.deleteById(carId);
        return "success";
    }
}
