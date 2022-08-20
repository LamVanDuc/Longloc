package com.example.projectsem2.reponsitory;

import com.example.projectsem2.dto.dtoChiTietSanPham;
import com.example.projectsem2.entity.tblSanpham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SanPhamRepository extends JpaRepository<tblSanpham ,Long> {
    tblSanpham findByIdSanpham(Long id);

    @Query("select new com.example.projectsem2.dto.dtoChiTietSanPham(t.idSanpham ,t.idNhacungcap , t.idDanhmuc , t.img , t.tenSanPham , t.moTa , t.thuongHieu , ct.idChitietsanpham , ct.phanLoai , ct.mauSac , ct.kichCo , ct.chatLieu , ct.soLuong , ct.giaBan ) from tblSanpham t inner join tblChitietsanpham ct on t.idSanpham = ct.idSanpham where t.idSanpham = ?1")
    List<dtoChiTietSanPham> findChitietSanPham();

}
