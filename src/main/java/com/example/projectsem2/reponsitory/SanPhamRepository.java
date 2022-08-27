package com.example.projectsem2.reponsitory;


import com.example.projectsem2.entity.tblSanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<tblSanpham ,Long> {


    tblSanpham findByIdSanpham(Long id);


    List<tblSanpham> findByIdSanphamChaNull();


    @Query("select t from tblSanpham t where t.idSanphamCha = ?1")
    List<tblSanpham> findByIdSanphamCha(Long id);


    tblSanpham findByIdSanphamChaAndMauSacAndKichCo(Long idSanpham , String mausac , String kichco);


    List<tblSanpham> findByIdDanhmucAndIdSanphamChaIsNull(Long id);
}
