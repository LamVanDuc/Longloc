package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.DanhMucService;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblDanhmuc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/danhmuc")
public class DanhMucController {
    @Autowired
    DanhMucService danhMucService;

    // get all
    @GetMapping("/getall")
    public List<tblDanhmuc> getAll(){
        return danhMucService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<responseObject> getByid(@PathVariable Long id){
        Optional<tblDanhmuc> danhmuc = danhMucService.optionalGetById(id);
        if (danhmuc.isPresent()){
          return  ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok"," query thành công",danhmuc));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new responseObject("false"," query không thành công",""));
    }

    // thêm danh mục

    @PostMapping("/add")
    public ResponseEntity<responseObject> themDanhmuc(@RequestBody tblDanhmuc danhmuc){
        return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok","thêm danh mục thành công",danhMucService.addDanhmuc(danhmuc)));
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<responseObject> updateDanhmuc(@PathVariable Long id , @RequestBody tblDanhmuc danhmuc){
        return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok","Chỉnh sửa danh mục thành công",danhMucService.addDanhmuc(danhmuc)));

    }

    //delete danh muc
    @DeleteMapping("/{id}")
    public ResponseEntity<responseObject> deleteDanhmuc(@PathVariable Long id){
        Boolean check = danhMucService.deleteDanhMuc(id);
        if (check){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new responseObject("ok","Xóa danh mục thành công",check));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("ok","Xóa danh mục không thành công",check));

    }
}
