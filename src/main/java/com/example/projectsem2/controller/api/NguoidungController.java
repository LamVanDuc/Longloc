package com.example.projectsem2.controller.api;


import com.example.projectsem2.Service.NguoiDungService;
import com.example.projectsem2.entity.tblNguoidung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/nguoidung")
public class NguoidungController {
    @Autowired
    NguoiDungService nguoiDungService;






    @GetMapping("/getall")
    public List<tblNguoidung> getAll(){
        return nguoiDungService.getAll();
    }

    @GetMapping("/email")
    public Optional<tblNguoidung> getEmail(){
       return nguoiDungService.findByEmail();
    }



}
