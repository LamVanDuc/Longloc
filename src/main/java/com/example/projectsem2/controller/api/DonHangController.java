package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.DonHangService;
import com.example.projectsem2.dto.giohang.donhang.dtoChiTietDonHang;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblDonhang;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "Đã sảy ra lỗi : "+ex.getMessage(),""));
        }
    }

    @GetMapping("/danhan")
    public ResponseEntity<responseObject> findTrangThaiDaNhanByNguoidung(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findDonhangByIdNguoiDungAndTrangthaiDaNhan()));
    }

    @GetMapping("/dahuy")
    public ResponseEntity<responseObject> findTrangThaiDaHuyByNguoidung(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findDonhangByIdNguoiDungAndTrangthaiHuydonhang()));
    }

    @GetMapping("/dangcho")
    public ResponseEntity<responseObject> findTrangThaiDangChoByNguoidung(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findDonhangByIdNguoiDungAndTrangthaiChoXacNhan()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<responseObject> finDonHang(@PathVariable String id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "query thành công" ,donHangService.finDonhang(id)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("ok" , "query Không thành công" ,ex.getLocalizedMessage()));
        }

    }


    @GetMapping("/danggiao")
    public ResponseEntity<responseObject> findTrangThaiDangGiaoByNguoidung(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findDonhangByIdNguoiDungAndTrangthaiDangGiao()));
    }

    @GetMapping("/all")
    public ResponseEntity<responseObject> findAllDonHangByNguoiDung(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findAllDonHangByNguoidung()));
    }




    @PostMapping("/add")
    public ResponseEntity<responseObject> themDonHang(@RequestBody tblDonhang donhang){
        try{
            tblDonhang donhang1 = donHangService.themDonHangWithGioHang(donhang);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "đặt hàng thành công" ,donhang1));
        }catch (Exception ex){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false","đã sảy ra lỗi!",ex.getLocalizedMessage()));
        }
    }
    @PostMapping("/huydon/{id}")
    public ResponseEntity<responseObject> huyDonhang(@PathVariable String id){
        Boolean check = donHangService.huyDonhang(id);
        if(check){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "Hủy thành công" ,check));

        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "Đơn hàng không trong Trạng thái đang chờ" ,check));
        }
    }
    @PostMapping("/nhandon/{id}")
    public ResponseEntity<responseObject> nhanDonhang(@PathVariable String id){
        Boolean check = donHangService.daNhanDonhang(id);
        if(check){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "Nhận thành công" ,check));

        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "Đơn hàng không trong Trạng thái đang giao" ,check));
        }
    }
    @PostMapping("/mualai/{id}")
    public ResponseEntity<responseObject> muaLaiDonHang(@PathVariable String id){
        try{
            Boolean donhang1 = donHangService.mualaidonhang(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "Add giỏ hàng thành công !" ,donhang1));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false","đã sảy ra lỗi!",ex.getLocalizedMessage()));
        }
    }











    @PostMapping("/xacnhangiao/{id}")
    public ResponseEntity<responseObject> giaoDonHang(@PathVariable String id){
        Boolean check = donHangService.nhanGiaoDonhang(id);
        if(check){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "Nhận thành công" ,check));

        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "Đơn hàng không trong Trạng thái đã được duyệt" ,check));
        }
    }

    @PostMapping("/duyet/{id}")
    public ResponseEntity<responseObject> duyetDonHang(@PathVariable String id){
        Boolean check = donHangService.duyetDonhang(id);
        if(check){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "Duyệt thành công" ,check));

        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("false" , "Đơn hàng không trong Trạng thái đang chờ" ,check));
        }
    }

    @GetMapping("/admin/danhan")
    public ResponseEntity<responseObject> findTrangThaiDaNhan(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findAllTrangthaiDaNhan()));
    }

    @GetMapping("/admin/dahuy")
    public ResponseEntity<responseObject> findTrangThaiDaHuy(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findAllTrangthaiHuydonhang()));
    }

    @GetMapping("/admin/dangcho")
    public ResponseEntity<responseObject> findTrangThaiDangCho(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findAllTrangthaiChoXacNhan()));
    }


    @GetMapping("/admin/danggiao")
    public ResponseEntity<responseObject> findTrangThaiDangGiao(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findAllTrangthaiDangGiao()));
    }

    @GetMapping("/admin/chonhangiao")
    public ResponseEntity<responseObject> findAllTrangthaiChoNhanGiao(){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "query thành công" ,donHangService.findAllTrangthaiChoNhanGiao()));
    }
    @GetMapping("/admin/all")
    public ResponseEntity<responseObject> findAllDonHang(){
        return ResponseEntity.status(HttpStatus.OK).body(
                new responseObject("ok" , "query thành công" ,donHangService.findAllDonHang()));
    }
    @GetMapping("/admin/get/{id}")
    public ResponseEntity<responseObject> finDonHangAdmin(@PathVariable String id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok" , "query thành công" ,donHangService.finDonhangAdmin(id)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new responseObject("ok" , "query Không thành công" ,ex.getLocalizedMessage()));
        }

    }

}
