package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblImage;
import java.util.List;

public interface ImageService {
    List<tblImage> getImageByIdSanpham(Long id);
}
