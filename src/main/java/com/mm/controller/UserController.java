package com.mm.controller;

import com.mm.base.BaseController;
import com.mm.domain.Manager;
import com.mm.domain.User;
import com.mm.service.UserService;
import com.mm.util.Consts;
import com.mm.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    /**
     * 若用户名为空，则列出所以用户
     * 若用户名非空，根据用户名找出用户
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping("findBySql")
    public String findBySql(String userName, Model model){
        String sql="select * from users where isDelete='0'";
        if(!isEmpty(userName)){
            sql+=" and userName='"+userName+"'";
        }
        sql+=" order by userId";
        Pager<User> pages=userService.getEntiryBySqlPage(sql);
        model.addAttribute("pages",pages);
        return "/user/user";

    }

    /**
     * 跳转到更新页面
     * @param userId
     * @param model
     * @return
     */
    @RequestMapping("update")
    public String update(Integer userId,Model model){
        User user=userService.getEntiryById(userId);
        model.addAttribute("user",user);
        return "/user/update";
    }

    /**
     * 更新操作
     * @param recUser
     * @param model
     * @return
     */
    @RequestMapping("exupdate")
    public String exupdate(User recUser,Model model){
        if(recUser!=null) {
            userService.update(recUser);
            return "redirect:/user/findBySql";
        }else{
            model.addAttribute("msg","修改失败，请重新修改");
            return "/user/update";
        }

    }
    /**
     * 删除操作
     */
    @RequestMapping("delete")
    public String delete(Integer userId,HttpServletRequest req){
        User user=userService.getEntiryById(userId);
        user.setIsDelete("1");
        userService.update(user);

        return "redirect:/user/findBySql";

    }
    /**
     * 跳转到添加用户
     *
     */
    @RequestMapping("add")
    public String add(HttpServletRequest request){
        Manager manager= (Manager) request.getSession().getAttribute(Consts.MESSAGE);
        System.out.println("ssssssssssss"+manager);
        return "/user/add";
    }
    /**
     * 添加用户
     */
    @RequestMapping("exadd")
    public String exadd(User user){
        int res=userService.insert(user);
        return "redirect:/user/findBySql";

    }

    @RequestMapping("view")
    public String view(HttpServletRequest request){
        User user= (User) request.getSession().getAttribute(Consts.USER);
        if(user==null){
            return "/login/uLogin";
        }
        return "/user/view";

    }
    @RequestMapping("exUpdate")
    public String exUpdate(User recUser,Model model){
        if(recUser!=null) {
            userService.update(recUser);

        }else{
            model.addAttribute("msg","修改失败，请重新修改");

        }
        return "/user/view";

    }
    @RequestMapping("/upass")
    public String upass(String oldpassword,String newpassword,String confirmpassword,HttpServletRequest request){
        //System.out.println("名字是是是："+oldpassword+"mimasssssss"+newpassword+"ssssssssssss"+confirmpassword);
        User user= (User) request.getSession().getAttribute(Consts.USER);
        user.setPassword(newpassword);
        userService.update(user);

        return "login/pass";
    }

}

