package com.mm.controller;

import com.mm.domain.Book;
import com.mm.domain.Sc;
import com.mm.domain.User;
import com.mm.service.BookService;
import com.mm.service.ScService;
import com.mm.util.Consts;
import com.mm.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/sc")
public class ScController {
    @Autowired
    ScService scService;
    @Autowired
    BookService bookService;

    @RequestMapping("findBySql")
    public String findBySql(Model model, HttpServletRequest request) {
        User user=(User)request.getSession().getAttribute(Consts.USER);
        if(user==null){
            return "redirect:/login/uLogin";
        }
        String sql="select * from scs where userId='"+user.getUserId()+"' order by scId desc";
        Pager<Sc> pagers=scService.getEntiryBySqlPage(sql);
        model.addAttribute("pagers",pagers);
        return "sc/my";


    }

    @RequestMapping("exadd")
    public String exadd(Integer bookId, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute(Consts.USER);
        if(user==null){
            return "redirect:/login/uLogin";
        }
        System.out.println("书籍id号为："+bookId);
        Sc sc=new Sc();
        sc.setUserId(user.getUserId());
        sc.setBookId(bookId);
        scService.insert(sc);

        Book book=bookService.getEntiryById(bookId);
        book.setScNum(book.getScNum()+1);
        bookService.update(book);

        return "redirect:/sc/findBySql";

    }
    //取消收藏
    @RequestMapping("delete")
    public String delete(Integer scId,HttpServletRequest request){
        User user=(User)request.getSession().getAttribute(Consts.USER);
        if(user==null){
            return "redirect:/login/uLogin";
        }
        scService.deleteById(scId);
        return "redirect:/sc/findBySql";
        //return "sc/findBySql";//是去找页面，而不是重新发送请求

    }

}
