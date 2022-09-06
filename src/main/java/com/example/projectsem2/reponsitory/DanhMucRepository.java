package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblDanhmuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DanhMucRepository extends JpaRepository<tblDanhmuc ,Long> {
    tblDanhmuc findByIdDanhmuc(Long id);

    List<tblDanhmuc> findByIdDanhmucChaIsNull();

    List<tblDanhmuc> findByIdDanhmucCha(Long id);

    tblDanhmuc findByTenDanhMuc(String name);

}
