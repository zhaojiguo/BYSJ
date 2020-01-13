package com.bysj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class IndexController{
    /**
     * 跳转到登录页
     */
    @RequestMapping("/buy")
    public String getIndex(){
        return "bysj/index.html";
    }

    /**
     * 跳转到注册页面
     */
    @RequestMapping("/reg")
    public  String getReg(){
        return "bysj/register.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping("/login")
    public String getLogin(){
        return "bysj/login.html";
    }
}
