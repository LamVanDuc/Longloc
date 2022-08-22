package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblDonhang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DonHangRepository extends JpaRepository<tblDonhang,String> {
    Optional<tblDonhang> findByIdNguoidungAndIdDonhang(Long idNguoidung , String idDonhang);
    tblDonhang findByIdDonhang(String idDonhang);
}
