package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblNguoidung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NguoidungReponsitory extends JpaRepository<tblNguoidung , Long> {
    Optional<tblNguoidung> findAllByEmailAndTrangThai(String email , String trangThai);
    Optional<tblNguoidung> findByEmail(String email);

    Boolean existsByEmailAndTrangThai(String email, String trangThai);
}
