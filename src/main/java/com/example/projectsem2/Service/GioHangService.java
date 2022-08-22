package com.example.projectsem2.Service;

import com.example.projectsem2.dto.dtoGioHangAndChiTietSanPham;
import com.example.projectsem2.entity.tblGiohang;

import java.util.List;
import java.util.Optional;

public interface GioHangService {
    List<dtoGioHangAndChiTietSanPham> getByIdNguoidung();

    tblGiohang addGioHang(tblGiohang newGiohang);

    tblGiohang updateGiohang(Long id , tblGiohang newGiohang);

    Boolean deleteGiohang(Long id);

    Optional<tblGiohang> getById(Long id);


}
