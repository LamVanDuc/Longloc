package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblDiachigiaohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DiaChiGiaoHangReponsitory extends JpaRepository<tblDiachigiaohang, Long> {

    List<tblDiachigiaohang> findByIdNguoidung(Long id);
}
