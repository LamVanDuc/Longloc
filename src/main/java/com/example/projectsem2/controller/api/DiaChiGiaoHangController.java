package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.DiaChiGiaoHangService;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblDiachigiaohang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/diachigiaohang")
public class DiaChiGiaoHangController {

    @Autowired
    DiaChiGiaoHangService diaChiGiaoHangService;

    @GetMapping("/getall")
    public List<tblDiachigiaohang> findByIdNguoidung(){
        return diaChiGiaoHangService.findByIdNguoidung();
    }

    @GetMapping("/macdinh")
    public ResponseEntity<responseObject> findMacDinh(){
        try{
            tblDiachigiaohang diachigiaohang = diaChiGiaoHangService.findByMac_Dinh();
            if (diachigiaohang != null){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new responseObject("ok","query thành công",diachigiaohang));
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new responseObject("false" , "query không thành công", "Không có địa chỉ giao hàng nào !"));
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "Đã sảy ra lỗi !" , ex.getLocalizedMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<responseObject> getById(@PathVariable Long id){
        Optional<tblDiachigiaohang> diachigiaohang = diaChiGiaoHangService.findById(id);
        if (diachigiaohang.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new responseObject("false" , "query không thành công", "Không tìm thấy địa chỉ giao hàng có id ="+id));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "query thành công", diachigiaohang));
        }
    }

    @PostMapping(value ="/add")
    public ResponseEntity<responseObject> add(@Valid @RequestBody tblDiachigiaohang diachigiaohang){
        try {
            tblDiachigiaohang diachigiaohang1 = diaChiGiaoHangService.add(diachigiaohang);
            if (diachigiaohang != null){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new responseObject("ok" , "Thêm địa chỉ giao hàng thành công",diachigiaohang1));
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new responseObject("false","Đã có lỗi sảy ra !" , "")
                );
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "đã xảy ra lỗi !",e.getLocalizedMessage()));
        }

    }

    @PostMapping("/change/{id}")
    public ResponseEntity<responseObject> changeDiaChi(@PathVariable Long id){
        try {
            tblDiachigiaohang check = diaChiGiaoHangService.changeDiaChiGiaoHang(id);
            if (check !=null){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new responseObject("ok" , "Thay đổi địa chỉ giao hàng thành công",check));
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new responseObject("false" , "đã xảy ra lỗi !","Không có địa chỉ giao hàng"));
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "đã xảy ra lỗi !",ex.getLocalizedMessage()));
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
