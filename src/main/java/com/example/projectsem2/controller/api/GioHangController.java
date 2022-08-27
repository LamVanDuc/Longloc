package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.GioHangService;
import com.example.projectsem2.dto.dtoGioHangAndChiTietSanPham;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblGiohang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/giohang")
public class GioHangController {

    @Autowired
    GioHangService gioHangService ;

    // get by id người dùng
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
    // load đặt hàng
    @GetMapping("/load")
    public ResponseEntity<responseObject> loadDatHang(){
        List<dtoGioHangAndChiTietSanPham> dtoGioHangAndChiTietSanPham = gioHangService.loadDathang();
        if (dtoGioHangAndChiTietSanPham.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("false" , "Không có đơn hàng", ""));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "Load Đặt hàng thành công", dtoGioHangAndChiTietSanPham));
        }
    }

    // add
    @PostMapping("/add")
    public ResponseEntity<responseObject> addGiohang(@RequestBody tblGiohang giohang){
        try{
            tblGiohang tblGiohang = gioHangService.addGioHang(giohang);
            return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok" ,"them thanh cong", tblGiohang));
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false",exception.getMessage(),exception.getLocalizedMessage()));
        }
    }


    //update
    @PutMapping("/{id}")
    public ResponseEntity<responseObject> updateGiohang(@PathVariable Long id , @RequestBody tblGiohang giohang){
        try {
            tblGiohang tblGiohang = gioHangService.updateGiohang(id , giohang);
            return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok", "Sửa giỏ hàng thành công", tblGiohang));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false", "Sửa giỏ hàng không thành công , đã sảy ra lỗi !", ex.getLocalizedMessage()));
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<responseObject> deleteGioHang(@PathVariable Long id){
        boolean check = gioHangService.deleteGiohang(id);
        if (check){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok", "Xóa giỏ hàng thành công !",check));
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false", "Xóa giỏ hàng không thành công , đã sảy ra lỗi !", check));

        }
    }




}
