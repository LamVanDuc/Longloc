package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblChitietdonhang;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ChiTietDonHangReponsitory extends JpaRepository<tblChitietdonhang,Long> {
    List<tblChitietdonhang> findByIdDonhang(String id);
}
