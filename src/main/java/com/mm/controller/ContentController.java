package com.mm.controller;

import com.mm.domain.Content;
import com.mm.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;

    @RequestMapping("findBySql")
    public String showAllContentPhotos(Content content,Integer categoryId,Model model){
        //System.out.println(content+"---"+categoryId);
        if(content.getContentNum()==null){
            content.setContentNum(1);
        }
        List<Content> contentPhotos=contentService.selectByEntiry(content);
        if(contentPhotos.size()<=0){
            model.addAttribute("msgcontent","后续还未更新");
        }else{
            model.addAttribute("msgcontent","");
        }
        model.addAttribute("contentPhotos", contentPhotos);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("content", content);




        return "/content/content";
    }

}
