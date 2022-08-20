package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblGiohang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GioHangReponsitory extends JpaRepository<tblGiohang , Long> {
}
