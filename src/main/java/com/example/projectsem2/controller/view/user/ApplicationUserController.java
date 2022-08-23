package com.example.projectsem2.controller.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationUserController {
    @GetMapping("/checkout")
    public String getCheckout(){
        return "checkout";
    }
}
