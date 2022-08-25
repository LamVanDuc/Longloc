package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.GioHangService;
import com.example.projectsem2.dto.dtoGioHangAndChiTietSanPham;
import com.example.projectsem2.dto.responseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/giohang")
public class GioHangController {

    @Autowired
    GioHangService gioHangService ;
    @GetMapping("/get")
    public ResponseEntity<responseObject> getByIdNguoidung(){
        List<dtoGioHangAndChiTietSanPham> gioHangList = gioHangService.getByIdNguoidung();

        if (gioHangList.size() >0){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "query thành công ", gioHangList));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new responseObject("ok","Chưa có sản phẩm nào trong giỏ hàng",gioHangList));
        }

    }

}
