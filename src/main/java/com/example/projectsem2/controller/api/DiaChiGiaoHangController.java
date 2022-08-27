package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.DiaChiGiaoHangService;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblDiachigiaohang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/diachigiaohang")
public class DiaChiGiaoHangController {

    @Autowired
    DiaChiGiaoHangService diaChiGiaoHangService;

    @GetMapping("/get")
    public List<tblDiachigiaohang> findByIdNguoidung(){
        return diaChiGiaoHangService.findByIdNguoidung();
    }

    @PostMapping("/add")
    public ResponseEntity<responseObject> add(@RequestBody tblDiachigiaohang diachigiaohang){
        tblDiachigiaohang diachigiaohang1 = diaChiGiaoHangService.add(diachigiaohang);
        if (diachigiaohang != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "Thêm địa chỉ giao hàng thành công",diachigiaohang1));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "đã xảy ra lỗi !",""));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<responseObject> update(@PathVariable Long id, @RequestBody tblDiachigiaohang diachigiaohang){
        tblDiachigiaohang tblDiachigiaohang = diaChiGiaoHangService.update(id,diachigiaohang);
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "Chỉnh sửa địa chỉ giao hàng thành công!",tblDiachigiaohang));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<responseObject> delete(@PathVariable Long id){
        Boolean check = diaChiGiaoHangService.delete(id);
        if (check){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "Xóa địa chỉ giao hàng thành công!",check));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "Đã sảy ra lỗi !",check));
        }
    }
}
