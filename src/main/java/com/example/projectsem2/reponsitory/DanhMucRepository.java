package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblDanhmuc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DanhMucRepository extends JpaRepository<tblDanhmuc ,Long> {
}
