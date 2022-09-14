package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblImage;

import java.util.List;

public interface ImgService {

    List<tblImage> getImgBySanPham(Long id);
    tblImage addImgBySanPham(tblImage tblImage);

}
