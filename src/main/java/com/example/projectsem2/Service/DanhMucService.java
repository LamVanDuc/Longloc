package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblDanhmuc;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DanhMucService {

    List<tblDanhmuc> getAll();

    List<tblDanhmuc> getDanhMucKhac(Long id);

    tblDanhmuc addDanhmuc(tblDanhmuc danhmuc);

    tblDanhmuc updateDanhmuc(Long id , tblDanhmuc danhmuc);

    Boolean deleteDanhMuc(Long id);

    Optional<tblDanhmuc> optionalGetById(Long id);

    tblDanhmuc getById(Long id);


}
