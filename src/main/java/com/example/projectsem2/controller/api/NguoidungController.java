package com.example.projectsem2.controller.api;


import com.example.projectsem2.Service.NguoiDungService;
import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.dtoThayDoiNguoiDung;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblNguoidung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/changepassword")
    public ResponseEntity<responseObject> changePassword(@RequestBody dtoThayDoiNguoiDung dtoThayDoiNguoiDung){
        try {
            tblNguoidung nguoidung = nguoiDungService.changePassword(dtoThayDoiNguoiDung);

            return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok", "thay đổi password thành công" , nguoidung));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false", "Đã sảy ra lỗi !" , ex));
        }
    }

    @PostMapping("/changephone")
    public ResponseEntity<responseObject> changePhonenumber(@RequestBody dtoThayDoiNguoiDung dtoThayDoiNguoiDung){
        try {
            String phone = dtoThayDoiNguoiDung.getPhoneNumber();
            Boolean checkNumber = dtoThayDoiNguoiDung.getPhoneNumber().startsWith("0");
            if (checkNumber.equals(false)){
                dtoThayDoiNguoiDung.setPhoneNumber("0"+dtoThayDoiNguoiDung.getPhoneNumber());
            }
            if(dtoThayDoiNguoiDung.getPhoneNumber().length() !=10 || checkNumber.equals(false) || GenaricClass.isNumeric(dtoThayDoiNguoiDung.getPhoneNumber()).equals(false)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new responseObject("false","Số điện thoại không hợp lệ !",""));
            }
            if(dtoThayDoiNguoiDung.getPhoneNumber().length() <10 || dtoThayDoiNguoiDung.getPhoneNumber().length() >12 || checkNumber.equals(false)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new responseObject("false","Số điện thoại phải lớn hơn hoặc = 10 và bắt đầu từ 0 !",""));
            }

            tblNguoidung nguoidung = nguoiDungService.update(dtoThayDoiNguoiDung);

            return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok", "thay đổi số điện thoại thành công" , nguoidung));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false", "đã xảy ra lỗi!" , ex));
        }
    }


}
