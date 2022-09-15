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
        return "admin/admin-index";
    }
    @GetMapping("/login")
    public String getLoginAdmin(){
        return "admin/login";
    }

    @GetMapping("/product")
    public String getAddProduct(){
        return "admin/admin-add-product";
    }

    @GetMapping("/products")
    public String getProducts(){
        return "admin/admin-products";
    }

    @GetMapping("/rditproduct")
    public String geteditProduct(){
        return "admin/admin-account";
    }
    @GetMapping("/donhang")
    public String getdonhang(){
        return "admin/donhang";
    }

    @GetMapping("/chitietdonhang")
    public String getDetailDonhang(){
        return "admin/detaildonhang";
    }

}
