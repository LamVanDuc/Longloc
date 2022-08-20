package com.example.projectsem2.controller.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationUserController {
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

    @GetMapping("/blog")
    public String getBlog(){return "blog";}
}
