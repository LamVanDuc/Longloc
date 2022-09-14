package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblDiachigiaohang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiaChiGiaoHangReponsitory extends JpaRepository<tblDiachigiaohang, Long> {

    List<tblDiachigiaohang> findByIdNguoidung(Long id);
    Optional<tblDiachigiaohang> findByIdDiachigiaohang(Long id);
//    tblDiachigiaohang findByIdDiachigiaohang(Long id);

    tblDiachigiaohang findByIdNguoidungAndMacDinh(Long idNguoidung , String macdinh);

    Boolean existsByIdNguoidungAndMacDinh(Long idNguoidung , String macdinh);

    Optional<tblDiachigiaohang> findByIdDiachigiaohangAndIdNguoidung(Long idDiachi , Long idNguoidung);
}
