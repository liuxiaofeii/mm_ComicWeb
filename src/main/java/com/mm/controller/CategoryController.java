package com.mm.controller;

import com.mm.base.BaseController;
import com.mm.domain.Book;
import com.mm.domain.Category;
import com.mm.mapper.CategoryMapper;
import com.mm.service.CategoryService;
import com.mm.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("findBySql")
    public String findBySql(Model model){
        String sql="select * from categorys where isDelete='0'";
        Pager<Category> pages=categoryService.getEntiryBySqlPage(sql);
        model.addAttribute("pages",pages);

        return "/category/category";
    }

    /**
     * 添加
     *
     */
    @RequestMapping("add")
    public String add(Model model){
        return "/category/add";
    }

    @RequestMapping("exadd")
    public String exadd(Model model,String categoryName){
        Category category=new Category();
        category.setCategoryName(categoryName);
        int res=categoryService.insert(category);
        if(res>0){
            model.addAttribute("mesg","添加成功");

        }else{
            model.addAttribute("mesg","添加失败");
        }
        String sql="select * from categorys where isDelete='0'";
        Pager<Category> pages=categoryService.getEntiryBySqlPage(sql);
        model.addAttribute("pages",pages);

        return "/category/category";
    }
    @RequestMapping("delete")
    public String delete(Integer categoryId,Model model){

        Category category=categoryService.getEntiryById(categoryId);
        category.setIsDelete("1");
        categoryService.updateById(category);
       return "redirect:findBySql";
    }

}
