package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblImage;
import com.example.projectsem2.reponsitory.ImageChiTietSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageChiTietSanPhamRepository imageChiTietSanPhamRepository;
    @Override
    public List<tblImage> getImageByIdSanpham(Long id) {
        return imageChiTietSanPhamRepository.findByIdSanpham(id);
    }
}
