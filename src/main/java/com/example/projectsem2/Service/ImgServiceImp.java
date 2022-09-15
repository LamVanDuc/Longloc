package com.example.projectsem2.Service;

import com.example.projectsem2.entity.tblImage;
import com.example.projectsem2.reponsitory.ImgReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ImgServiceImp implements ImgService{
    @Autowired
    ImgReposetory reposetory;


    @Override
    public List<tblImage> getImgBySanPham(Long id) {
        return reposetory.findByIdSanpham(id);
    }

    @Override
    public tblImage addImgBySanPham(tblImage tblImage) {
        return reposetory.save(tblImage);
    }
}
