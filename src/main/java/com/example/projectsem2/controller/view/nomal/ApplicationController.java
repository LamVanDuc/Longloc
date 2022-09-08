package com.example.projectsem2.controller.view.nomal;

import com.example.projectsem2.Service.NguoiDungService;
import com.example.projectsem2.entity.tblNguoidung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
            return "donmua";
        }else{
            model.addAttribute("nguoidung",null);
        }


        return "Login";
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


    @GetMapping("/dangky")
    public String getDangKy(Model model){
        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
            return "donmua";
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "dangky";
    }



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

    @GetMapping("/infomation")
    public String thongTinCaNhan(Model model){

        Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


        if (nguoidungOptinal.isPresent()){
            model.addAttribute("nguoidung",nguoidungOptinal.get());
        }else{
            model.addAttribute("nguoidung",null);
        }
        return "thongtincanhan";
    }


    @GetMapping("/danhmuc/{danhmuc}")
    public String getDanhmuc(){
        return "/danhmuc";
    }

}
