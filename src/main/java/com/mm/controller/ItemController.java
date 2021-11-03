package com.mm.controller;

import com.mm.base.BaseController;
import com.mm.service.BookService;
import com.mm.service.CategoryService;
import com.mm.service.ContentService;
import com.mm.util.Consts;
import com.mm.util.Pager;
import com.mm.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {
    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ContentService contentService;

    /**
     * 展示页面
     * @param model
     * @param book
     * @param request
     * @return
     */
    @RequestMapping("findBySql")
    public String showAllBook(Model model, Book book, HttpServletRequest request){
        if(Consts.MANAGER==null){
            return "login/mLogin";
        }
        String sql="select * from books where isDelete='0'";
        if(!isEmpty(book.getBookName())){
            sql+=" and bookName like '%"+book.getBookName()+"%'";
        }
        sql+=" order by bookId";
        Pager<Book> pages=bookService.getEntiryBySqlPage(sql);
        model.addAttribute("pages",pages);
        return "/item/item";

    }
    /**
     * 跳转到修改页面
     *
     */
    @RequestMapping("update")
    public String update(Model model,Integer bookId){
        Book book=bookService.getEntiryById(bookId);
        String sql="select * from categorys where isDelete='0'";
        List<Category> types= categoryService.getListBySql(sql);
        model.addAttribute("book",book);
        model.addAttribute("types",types);
        return "/item/update";
    }

    /**
     * 修改业务代码
     * @param book
     * @return
     */
    @RequestMapping("exUpdate")
    public String exUpdate(Book book){
        if("免费".equals(book.getBookFree())){book.setBookFree("1"); }
        else{book.setBookFree("0");}
        bookService.update(book);
        return "redirect:/item/findBySql";
    }

    /**
     * 删除
     * @param bookId
     * @return
     */
    @RequestMapping("delete")
    public String delete(Integer bookId){
        Book book=bookService.getEntiryById(bookId);
        if(book==null){
            return "redirect:/item/findBySql";
        }
        book.setIsDelete("1");
        bookService.updateById(book);
        return "redirect:/item/findBySql";
    }
    @RequestMapping("add")
    public String add(Model model){
        String sql="select * from categorys where isDelete='0'";
        List<Category> categoryList=categoryService.getListBySql(sql);
        model.addAttribute("types",categoryList);
        return "/item/add";

    }
    @RequestMapping("exadd")
    public String exadd(Book book,Model model){

        if(book==null){
            model.addAttribute("msg","请填好全部信息再提交");
            return"/item/add";
        }
        if("免费".equals(book.getBookFree())){
            book.setBookFree("1");
        }else{
            book.setBookFree("0");
        }
        int res=bookService.insert(book);
        return "redirect:/item/findBySql";

    }
    @RequestMapping("view")
    public String view(Integer bookId,Model model){
        System.out.println("bbbbbbbbbbbbbb"+bookId);
        Book book=bookService.getEntiryById(bookId);
        System.out.println("aaaaaaaaaaaaa"+book);
        model.addAttribute("obj",book);
        List<Content> contents=contentService.load(bookId);
        model.addAttribute("contents",contents);
        return "/item/view";
    }
    //分类二级页
    @RequestMapping("booklist")
    public String booklist(Integer categoryId,Model model,HttpServletRequest request){
        User user=(User)request.getSession().getAttribute(Consts.USER);
//        if(user==null){
//            return "redirect:/login/uLogin";
//        }
        String sql="select * from books where isDelete='0' and categoryId="+categoryId;
        Pager<Book> pagers=bookService.getEntiryBySqlPage(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("categoryId",categoryId);
        return "item/booklist";

    }
    @RequestMapping("payComic")
    public String payComic(Model model){
        String sql="select * from books where isDelete='0' and bookFree='0'";
        Pager<Book> pagers=bookService.getEntiryBySqlPage(sql);
        model.addAttribute("pagers",pagers);
        return "item/paybooklist";
    }

    @RequestMapping("freeComic")
    public String freeComic(Model model){
        String sql="select * from books where isDelete='0' and bookFree='1'";
        Pager<Book> pagers=bookService.getEntiryBySqlPage(sql);
        model.addAttribute("pagers",pagers);
        return "/item/freebooklist";
    }
    @RequestMapping("searchBook")
    public String searchBook(Model model,String condition){

        if(condition.length()<=0){
            condition=null;
        }else{
            condition="%"+condition+"%";
        }
        String sql="select * from books where bookName like '"+condition+"'";
        Pager<Book> pagers=bookService.getEntiryBySqlPage(sql);
        model.addAttribute("pagers",pagers);
        return "/item/searchbooklist";
    }

}
