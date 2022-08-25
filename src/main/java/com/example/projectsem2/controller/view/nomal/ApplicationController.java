package com.example.projectsem2.controller.view.nomal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {

    @RequestMapping(value = {"","/","/home","/index"},method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "Login";
    }

    @GetMapping("/register")
    public String getRegister(){
        return "Register";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }

    @GetMapping("/shop")
    public String getShop(){
        return "shop";
    }

    @GetMapping("/layout")
    public String getLayout(){
        return "layout";
    }

    @GetMapping("/blog")
    public String getBlog(){
        return "blog";
    }

    @GetMapping("/giohang")
    public String getGioHang(){
        return "giohang";
    }

    @GetMapping("/detail")
    public String getProductDetail(){
        return "single-product-details";
    }
}
