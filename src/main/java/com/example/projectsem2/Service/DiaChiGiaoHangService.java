package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblDiachigiaohang;
import java.util.List;

public interface DiaChiGiaoHangService {

    List<tblDiachigiaohang> findByIdNguoidung();

    tblDiachigiaohang add(tblDiachigiaohang diachigiaohang);

    tblDiachigiaohang update(Long id , tblDiachigiaohang newDiachigiaohang);

    Boolean delete(Long id);
}
