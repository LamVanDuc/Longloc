package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.entity.tblSanpham;
import com.example.projectsem2.reponsitory.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService{
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<tblSanpham> findAllSanpham() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Optional<tblSanpham> findOptionalByIdSanpham(Long id) {
        return sanPhamRepository.findById(id);
    }


    @Override
    public tblSanpham themSanPham(tblSanpham newSanpham) {
        return sanPhamRepository.save(newSanpham);
    }



    @Override
    public tblSanpham updateSanpham(Long id , tblSanpham newSanpham) {
        if (sanPhamRepository.existsById(id)){
            tblSanpham sanpham = sanPhamRepository.findByIdSanpham(id);
            sanpham.setImg(newSanpham.getImg());
            sanpham.setTenSanPham(newSanpham.getTenSanPham());
            sanpham.setMoTa(newSanpham.getMoTa());
            sanpham.setNgayChinhSua(GenaricClass.dateTimeNow());
            return sanPhamRepository.save(sanpham);
        }
        return null;
    }

    @Override
    public tblSanpham findSanphamByid(Long id) {
        return sanPhamRepository.findByIdSanpham(id);
    }
}
