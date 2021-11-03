package com.mm.controller;

import com.mm.base.BaseController;
import com.mm.domain.Book;
import com.mm.domain.Category;
import com.mm.domain.Manager;
import com.mm.domain.User;
import com.mm.service.BookService;
import com.mm.service.CategoryService;
import com.mm.service.ManagerService;
import com.mm.service.UserService;
import com.mm.util.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

    @Autowired
    ManagerService managerService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "login/mLogin";
    }
    @RequestMapping(value = "toLogin")
    public String toLogin(Manager recvManager, HttpServletRequest request){
        System.out.println("登录用户名称："+recvManager.getManagerName());
        Manager manager= managerService.getEntiryByEntiry(recvManager);

        request.getSession().setAttribute(Consts.MESSAGE,manager);
        if(manager==null){
            return "redirect:out";
        }
        request.getSession().setAttribute(Consts.MANAGER,manager);

        return "login/mIndex";
    }
    @RequestMapping(value = "out")
    public String out(HttpServletRequest request){
        request.getSession().setAttribute(Consts.MANAGER,null);
        return "login/mLogin";
    }
    @RequestMapping(value="mLogin")
    public String mLogin(){
        return "login/mLogin";
    }

    /**
     * 跳转到前台首页
     */
    @RequestMapping("uIndex")
    public String uIndex(Model model){
        //分类
        String sql1="select * from categorys where isDelete='0'";
        List<Category> categoryList=categoryService.getListBySql(sql1);
        model.addAttribute("types",categoryList);
        //按阅读量排序
        String sql2="select * from books where isDelete='0' order by bookReadNums desc";
        List<Book> bookList=bookService.getListBySql(sql2);
        //System.out.println(bookList);
        model.addAttribute("hotBook",bookList);
        //付费书籍
        String sql3="select * from books where isDelete='0' and bookFree='0'";
        List<Book> bookList2=bookService.getListBySql(sql3);
        model.addAttribute("payBook",bookList2);

        return "/login/uIndex";
    }
    @RequestMapping("uLogin")
    public String uLogin(){return "/login/uLogin";}

    @RequestMapping("utoLogin")
    public String utoLogin(User recvUser, Model model,HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        map.put("userName",recvUser.getUserName());
        map.put("password",recvUser.getPassword());
        User user=userService.getEntiryByMap(map);
        if(user!=null){
            request.getSession().setAttribute(Consts.USER,user);
            return "redirect:/login/uIndex";
        }else{
            model.addAttribute("errorlogin","用户名或者密码错误");
            return "/login/uLogin";
        }


    }
    @RequestMapping("uTui")
    public String uTui(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        return "redirect:/login/uIndex";
    }
    @RequestMapping("res")
    public String res(){
        return "/login/res";
    }
    @RequestMapping("toRes")
    public String toRes(User user){

        userService.insert(user);
        return "redirect:/login/uIndex";
    }
    @RequestMapping("/pass")
    public String pass(HttpServletRequest request){
        return "login/pass";
    }


}
