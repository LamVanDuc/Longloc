package com.example.projectsem2.Service;

import com.example.projectsem2.dto.dtoChiTietSanPham;
import com.example.projectsem2.entity.tblSanpham;

import java.util.List;
import java.util.Optional;

public interface SanPhamService {

    List<tblSanpham> findAllSanpham();

    Optional<tblSanpham> findByid(Long id);

    tblSanpham addSanpham(tblSanpham newSanpham);

    tblSanpham updateSanpham(Long id , tblSanpham newSanpham);

    tblSanpham findSanphamByid(Long id);

    Boolean deleteSanpham(Long id);

    dtoChiTietSanPham findChitietByIdSanpham(Long id);

    tblSanpham updateSoLuong(Long idSanpham , Long soLuong);

    tblSanpham findSanphamByIdSanphamchaAndMausacAndKichco(tblSanpham sanpham);


    List<tblSanpham> findSanPham(String name);


}
