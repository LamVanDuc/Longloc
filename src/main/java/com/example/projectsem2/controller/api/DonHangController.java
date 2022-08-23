package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.DonHangService;
import com.example.projectsem2.dto.dtoChiTietDonHang;
import com.example.projectsem2.dto.responseObject;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/donhang")
public class DonHangController {
    @Autowired
    DonHangService donHangService;

    @GetMapping("/q")
    public ResponseEntity<responseObject> findByIdDonhang(@RequestParam(value = "id") String id){
        try{
            dtoChiTietDonHang chiTietDonHang =  donHangService.getByIdDonHang(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" ,"query thành công !",chiTietDonHang));

        }catch (NotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new responseObject("false" , "Đơn hàng không tồn tại!",""));

        }catch (Exception exx){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new responseObject("false" , "Đã sảy ra lỗi : "+exx.getMessage(),""));
        }
    }
}
