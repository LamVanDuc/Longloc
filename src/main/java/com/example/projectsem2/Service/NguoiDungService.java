package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblNguoidung;
import java.util.List;
import java.util.Optional;

public interface NguoiDungService {

    List<tblNguoidung> getAll();
    Long idNguoidung();

    Optional<tblNguoidung> findByEmail();

    tblNguoidung update(String email , tblNguoidung newNguoidung);

    tblNguoidung delete(String email);
}
