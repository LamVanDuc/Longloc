package com.example.projectsem2.controller.api;


import com.example.projectsem2.Service.NguoiDungService;
import com.example.projectsem2.reponsitory.NguoidungReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NguoidungController {
    @Autowired
    NguoiDungService nguoiDungService;


}
