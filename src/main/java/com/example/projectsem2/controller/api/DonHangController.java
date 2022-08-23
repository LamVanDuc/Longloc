package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.DonHangService;
import com.example.projectsem2.dto.dtoChiTietDonHang;
import com.example.projectsem2.dto.responseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/donhang")
public class DonHangController {
    @Autowired
    DonHangService donHangService;

//    @GetMapping("/q")
//    public ResponseEntity<responseObject> getById(@RequestParam("id")String id){
//        try{
//            dtoChiTietDonHang donHang = donHangService.getByIdDonHang(id);
//            return ResponseEntity.status(HttpStatus.OK).body(
//                    new responseObject("ok","Query thành công !" ,donHang));
//        }catch (Exception ex){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new responseObject("false","Đã sảy ra lỗi",ex.getMessage()));
//        }
//
//    }
}
