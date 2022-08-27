package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblChitietdonhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<tblChitietdonhang , Long> {
    List<tblChitietdonhang> findByIdDonhang(String id);


}
