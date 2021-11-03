package com.mm;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mm.domain.*;
import com.mm.mapper.BookMapper;
import com.mm.service.*;
import com.mm.util.Pager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

//整合junit和spring，让junit在启动时候加载springIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件,需要用到的配置文件，如果是dao的话可以不用spring-service.xml
@ContextConfiguration({ "classpath:ApplicationContext_dao.xml", "classpath:ApplicationContext_service.xml", "classpath:springmvc.xml" })
public class TestSpring {
    @Autowired
    ManagerService managerService;
    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserService userService;
    @Autowired
    CarService carService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Test
    public void testSpring(){


        List<Manager> managerList=managerService.listAll();
    }
    @Test
    public void testSpring2(){
        List<Book> bookList=bookService.listAll();


    }
    @Test
    public void testSpring3(){
//        List<Book> bookList=bookService.listAll();
//        /**
//         * PageInfo包含所有页面信息，参数是List
//         */
//        PageInfo<Book> pageInfo=new PageInfo<>(bookList);
//        System.out.println("总页数"+pageInfo.getTotal());
//        System.out.println("第"+pageInfo.getPageNum()+"页");
        Pager<Book> pages=bookService.getEntiryBySqlPage("select * from books");
        List<Book> datas=pages.getDatas();
        for(Book data:datas){
            System.out.println("书的名称"+data.getBookName());
            System.out.println("封面地址"+data.getBookPhoto());
            System.out.println("书籍等级"+data.getBookFree());
            System.out.println("上架情况"+data.getIsDelete());
        }

    }
    @Test
    public void testSpring4(){
        PageHelper.startPage(2,2);
        List<Book> bookList=bookService.listAll();
        Pager<Book> pagers=new Pager<>(bookList);
        List<Book> page= pagers.getDatas();
        for(Book data:page){
            System.out.println("数据库中的书籍："+data.getBookName());
        }




    }
    @Test
    public void testSpring5(){
//        List<Category> categoryList=categoryService.listAll();
//        for(Category category:categoryList){
//            System.out.println(category);
//        }
        Integer data=13;
//        categoryService.deleteById(data);
        Category category=categoryService.getEntiryById(data);
//
//        List<Category> categoryList=categoryService.listAll();
//        for(Category category:categoryList){
//            System.out.println(category);
//        }




    }
    @Test
    public void testSpring6(){
        List<User> userList=userService.listAll();

    }
    @Test
    public void testSpring7(){
        List<Car> lists= (List<Car>) carService.getEntiryById2();
        lists.forEach(System.out::println);

    }
    @Test
    public void testSpring8(){
        List<Order> lists= orderService.findAll();
        lists.forEach(System.out::println);
//        List<OrderDetail> lists= orderDetailService.findAll();
//        lists.forEach(System.out::println);

    }

    @Test
    public void testSpring9(){
        String sql="select * from books where isDelete=0";
        Pager<Book> lists= bookService.getEntiryBySqlPage(sql);
        System.out.println(lists);
//        List<OrderDetail> lists= orderDetailService.findAll();
//        lists.forEach(System.out::println);

    }
}
