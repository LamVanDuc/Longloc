package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblSanpham;

import java.util.List;
import java.util.Optional;


public interface SanPhamService {

    List<tblSanpham> findAllSanpham();

    Optional<tblSanpham> findOptionalByIdSanpham(Long id);

    tblSanpham themSanPham(tblSanpham newSanpham);

    tblSanpham updateSanpham(Long id , tblSanpham newSanpham);

    tblSanpham findSanphamByid(Long id);

}
