package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.DanhMucService;
import com.example.projectsem2.entity.tblDanhmuc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/danhmuc")
public class DanhMucController {
    @Autowired
    DanhMucService danhMucService;

    @GetMapping("/getall")
    public List<tblDanhmuc> getAll(){
        return danhMucService.getAll();
    }
}
