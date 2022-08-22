package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblChitietsanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChiTietSanPhamReponsitory extends JpaRepository<tblChitietsanpham , Long> {

    List<tblChitietsanpham> findByIdSanpham(Long id);

    tblChitietsanpham findByIdChitietsanpham(Long id);

}
