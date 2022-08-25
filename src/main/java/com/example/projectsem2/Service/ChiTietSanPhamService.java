package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblChitietsanpham;

import java.util.List;
import java.util.Optional;

public interface ChiTietSanPhamService {

    List<tblChitietsanpham> findByIdSanPham(Long id);

    tblChitietsanpham addChitietsanpham(tblChitietsanpham chitietsanpham);

    tblChitietsanpham updateChitietsanpham(Long id , tblChitietsanpham chitietsanpham);

    Boolean deleteChitietsanpham(Long id);

    Optional<tblChitietsanpham> optionalGetById(Long id);

    tblChitietsanpham getById(Long id);

}
