package com.example.projectsem2.reponsitory;


import com.example.projectsem2.entity.tblSanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<tblSanpham ,Long> {
    tblSanpham findByIdSanpham(Long id);


}
