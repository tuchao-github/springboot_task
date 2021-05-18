package com.lagou.controller;

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
public class LoginController {

    @RequestMapping("/toLoginPage")
    public String toLoginPage(Model model){
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }
}
