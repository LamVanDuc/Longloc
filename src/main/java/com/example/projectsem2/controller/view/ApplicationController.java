package com.example.projectsem2.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/login")
    public String getLogin(){
        return "Login";
    }
}
