package com.example.cassecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")  //只有这些角色才能访问
    public String test(ModelMap modelMap){
        //取当前登录用户
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("当前登录用户："+username);
        modelMap.addAttribute("username",username);
        return "success";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }

}
