package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblNguoidung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoidungReponsitory extends JpaRepository<tblNguoidung , Long> {
}
