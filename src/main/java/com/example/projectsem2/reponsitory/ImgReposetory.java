package com.example.projectsem2.reponsitory;

import com.example.projectsem2.entity.tblImage;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImgReposetory extends JpaRepository<tblImage , Long> {

    List<tblImage> findByIdSanpham(Long id);


}
