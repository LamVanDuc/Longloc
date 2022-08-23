package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblGiohang;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface GioHangReponsitory extends JpaRepository<tblGiohang , Long> {
    List<tblGiohang> findByIdNguoidung(Long id);

    Boolean existsByIdChitietsanpham(Long id);

    tblGiohang findByIdNguoidungAndIdChitietsanpham(Long idNguoidung , Long idChitietsanpham);
}
