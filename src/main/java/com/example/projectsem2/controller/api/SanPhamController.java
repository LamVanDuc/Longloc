package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.SanPhamService;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblSanpham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sanpham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;


    @GetMapping("/getall")
    public List<tblSanpham> findAllproduct(){
        return sanPhamService.findAllSanpham();
    }

    @GetMapping("/{id}")
    public ResponseEntity<responseObject> findByIdSanpham(@PathVariable Long id){
        Optional<tblSanpham> sanpham = sanPhamService.findOptionalByIdSanpham(id);
        if (sanpham.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new responseObject("false" ,"không tìm thấy sản phẩm" ,""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok" , "query thành công" , sanpham));
    }
}
