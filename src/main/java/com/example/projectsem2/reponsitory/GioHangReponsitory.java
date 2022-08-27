package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblGiohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GioHangReponsitory extends JpaRepository<tblGiohang , Long> {
    List<tblGiohang> findByIdNguoidung(Long id);

    Boolean existsByIdSanpham(Long id);

    tblGiohang findByIdNguoidungAndIdSanpham(Long idNguoidung , Long idSanpham);

    tblGiohang findByIdGiohang(Long id);
}
