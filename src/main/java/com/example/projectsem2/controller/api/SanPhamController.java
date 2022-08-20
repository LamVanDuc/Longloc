package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.SanPhamService;
import com.example.projectsem2.entity.tblSanpham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sanpham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/getall")
    public List<tblSanpham> findAllproduct(){
        return sanPhamService.findAllSanpham();
    }
}
