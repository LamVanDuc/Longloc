package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblDiachigiaohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaChiGiaoHangReponsitory extends JpaRepository<tblDiachigiaohang, Long> {
}
