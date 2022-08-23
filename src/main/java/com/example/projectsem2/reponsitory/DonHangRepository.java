package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblDonhang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonHangRepository extends JpaRepository<tblDonhang,String> {
    tblDonhang findByIdDonhang(String id);
}
