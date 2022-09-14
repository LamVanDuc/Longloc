package com.example.projectsem2.reponsitory;


import com.example.projectsem2.entity.tblDonhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonHangRepository extends JpaRepository<tblDonhang,String> {

    tblDonhang findByIdDonhang(String id);

    List<tblDonhang> findByIdNguoidung(Long id);

    Optional<tblDonhang> findByIdDonhangAndIdNguoidung(String idDonhang , Long idNguoidung);

    List<tblDonhang> findByTrangThai(String trangthai);

    List<tblDonhang> findByIdNguoidungAndTrangThai(Long idNguoidung,String trangthai);

    tblDonhang findByIdNguoidungAndIdDonhang(Long idNguoidung, String idDonhang);


}
