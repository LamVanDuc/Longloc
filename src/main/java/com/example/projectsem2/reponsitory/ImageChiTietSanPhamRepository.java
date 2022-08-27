package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImageChiTietSanPhamRepository extends JpaRepository<tblImage ,Long> {

    List<tblImage> findByIdSanpham(Long id);
}
