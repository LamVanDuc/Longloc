package com.example.projectsem2.Service;

import com.example.projectsem2.dto.dtoThayDoiNguoiDung;
import com.example.projectsem2.entity.tblNguoidung;
import java.util.List;
import java.util.Optional;

public interface NguoiDungService {

    List<tblNguoidung> getAll();
    Long idNguoidung();

    Optional<tblNguoidung> findByEmail();

    tblNguoidung update(dtoThayDoiNguoiDung dtoThayDoiNguoiDung);

    tblNguoidung delete(String email);

    tblNguoidung changePassword(dtoThayDoiNguoiDung dtoThayDoiNguoiDung);
}
