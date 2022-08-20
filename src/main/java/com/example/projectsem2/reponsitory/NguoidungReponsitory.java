package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblNguoidung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NguoidungReponsitory extends JpaRepository<tblNguoidung , Long> {
}
