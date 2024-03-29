package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.SanPhamService;
import com.example.projectsem2.dto.dtoChiTietSanPham;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblSanpham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sanpham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;


    // get all
    @GetMapping("/getall")
    public List<tblSanpham> findAllproduct(){
        return sanPhamService.findAllSanpham();
    }


    //find by id
    @GetMapping("/{id}")
    public ResponseEntity<responseObject> findById(@PathVariable Long id){
        Optional<tblSanpham> sanpham = sanPhamService.findByid(id);
        if (sanpham.isPresent()){
           return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok","query thành công",sanpham));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new responseObject("false","Sản phẩm không tồn tại",""));
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<responseObject> findById( @PathVariable String name){
        List<tblSanpham> sanpham = sanPhamService.findSanPham(name);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok","query thành công",sanpham));
    }


    //getdetail
    @GetMapping("/detail/{id}")
    public ResponseEntity<responseObject> findDetailsSanPham(@PathVariable Long id){
        dtoChiTietSanPham chiTietSanPham = sanPhamService.findChitietByIdSanpham(id);
        return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok","query thành công ",chiTietSanPham));
    }

    // get size and color
    @PostMapping ("/getsac")
    public ResponseEntity<responseObject> findSanphamByIdSanphamchaAndMausacAndKichco(@RequestBody tblSanpham sanpham){
        tblSanpham tblSanpham = sanPhamService.findSanphamByIdSanphamchaAndMausacAndKichco(sanpham);
        if (tblSanpham == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "Query Không thành công" , "Sản Phẩm Không tồn tại !"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "Query thành công" , tblSanpham));
    }

    //add
    @PostMapping("/add")
    public ResponseEntity<responseObject> themSanpham(@RequestBody tblSanpham sanpham){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok","Thêm sản phẩm thành công ", sanPhamService.addSanpham(sanpham)));
    }


    //update
    @PutMapping("/{id}")
    public ResponseEntity<responseObject> updateSanpham(@PathVariable Long id,@RequestBody tblSanpham sanpham){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "Chỉnh sửa sản phẩm thành công",sanPhamService.updateSanpham(id,sanpham)));
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<responseObject> deleteSanpham(@PathVariable Long id){
        Boolean checkDelete = sanPhamService.deleteSanpham(id);
        if (checkDelete){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok","xóa sản phẩm thành công",checkDelete));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("ok" , "xóa sản phẩm không thành công , đã sảy ra lỗi !",checkDelete));
        }
    }



}
