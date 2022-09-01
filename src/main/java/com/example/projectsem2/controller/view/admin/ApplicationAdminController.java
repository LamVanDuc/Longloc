package com.example.projectsem2.controller.view.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ApplicationAdminController {


    @GetMapping("/index")
    public String getCheckout(){
        return "admin/index";
    }

}
