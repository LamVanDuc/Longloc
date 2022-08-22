package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblDanhmuc;
import com.example.projectsem2.entity.tblNhacungcap;

import java.util.List;
import java.util.Optional;

public interface NhaCungCapService {
    List<tblNhacungcap> getAll();

    tblNhacungcap addNhacungcap(tblNhacungcap nhacungcap);

    tblNhacungcap updateNhacungcap(Long id , tblNhacungcap nhacungcap);

    Boolean deleteNhacungcap(Long id);

    Optional<tblNhacungcap> optionalGetById(Long id);

    tblNhacungcap getById(Long id);
}
