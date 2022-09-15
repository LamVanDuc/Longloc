package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblDiachigiaohang;
import java.util.List;
import java.util.Optional;

public interface DiaChiGiaoHangService {

    List<tblDiachigiaohang> findByIdNguoidung();

    tblDiachigiaohang findByMac_Dinh() throws RuntimeException;

    Optional<tblDiachigiaohang> findById(Long id);

    Optional<tblDiachigiaohang> findDiachigiaohang(Long id);

    tblDiachigiaohang changeDiaChiGiaoHang(Long id);

    tblDiachigiaohang add(tblDiachigiaohang diachigiaohang);

    tblDiachigiaohang update(Long id , tblDiachigiaohang newDiachigiaohang);

    Boolean delete(Long id);
}
