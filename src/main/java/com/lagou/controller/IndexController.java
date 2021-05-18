package com.lagou.controller;

import com.lagou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LoginController.java
 * @Description TODO
 * @createTime 2021年05月18日 13:18:00
 */
@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("articleList",articleService.findAll());
        return "client/index";
    }
}
