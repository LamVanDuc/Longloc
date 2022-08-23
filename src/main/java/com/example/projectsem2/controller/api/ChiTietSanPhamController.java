package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.ChiTietSanPhamService;
import com.example.projectsem2.entity.tblChitietsanpham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/chitietsanpham")
public class ChiTietSanPhamController {

    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("/{id}")
    public List<tblChitietsanpham> getByIdSanPham(@PathVariable Long id){
        return chiTietSanPhamService.getByIdSanPham(id);
    }
}
