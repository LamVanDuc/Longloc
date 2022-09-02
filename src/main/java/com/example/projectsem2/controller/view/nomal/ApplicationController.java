package com.example.projectsem2.controller.view.nomal;

import com.example.projectsem2.Service.NguoiDungService;
import com.example.projectsem2.entity.tblNguoidung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ApplicationController {
    @Autowired
    private NguoiDungService nguoiDungService;


    @RequestMapping(value = {"","/","/home","/index"},method = RequestMethod.GET)
    public String getIndex(Model model){
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "index";
    }



    @GetMapping("/login")
    public String getLogin(Model model){
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "Login";
    }



    @GetMapping("/register")
    public String getRegister(Model model){
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "Register";
    }


    @GetMapping("/contact")
    public String getContact(Model model){
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "contact";
    }



    @GetMapping("/shop")
    public String getShop(Model model){
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "shop";
    }



    @GetMapping("/layout")
    public String getLayout(Model model){
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }


        return "layout";
    }



    @GetMapping("/blog")
    public String getBlog(Model model){
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "blog";
    }



    @GetMapping("/giohang")
    public String getGioHang(Model model) {
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "giohang";
    }



    @GetMapping("/thanhtoan")
    public String getThanhToan(Model model) {
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "thanhtoan";
    }

<<<<<<< Updated upstream

=======
    @GetMapping("/dangky")
    public String getDangKy(){
        return "dangky";
    }
>>>>>>> Stashed changes

    @GetMapping("/detail")
    public String getProductDetail(Model model){

        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "single-product-details";
    }
}
