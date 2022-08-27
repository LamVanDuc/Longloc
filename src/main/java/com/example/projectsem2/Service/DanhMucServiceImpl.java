package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.danhmuc.dtoDanhmuc;
import com.example.projectsem2.dto.danhmuc.dtoDanhmucAndSanpham;
import com.example.projectsem2.entity.tblDanhmuc;
import com.example.projectsem2.entity.tblSanpham;
import com.example.projectsem2.reponsitory.DanhMucRepository;
import com.example.projectsem2.reponsitory.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class DanhMucServiceImpl implements DanhMucService{

    @Autowired
    DanhMucRepository danhMucRepository;

    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<tblDanhmuc> getAll() {
        return danhMucRepository.findAll();
    }

    @Override
    public List<tblDanhmuc> getDanhMucKhac(Long id) {
        return null;
    }

    @Override
    public tblDanhmuc addDanhmuc(tblDanhmuc danhmuc) {
        return danhMucRepository.save(danhmuc);
    }

    @Override
    public tblDanhmuc updateDanhmuc(Long id, tblDanhmuc danhmuc) {
        tblDanhmuc updateDanhmuc = danhMucRepository.findById(id).map(dm->{
            dm.setMoTa(danhmuc.getMoTa());
            dm.setNgayChinhSua(GenaricClass.dateTimeNow());
            dm.setTenDanhMuc(danhmuc.getTenDanhMuc());
            return danhMucRepository.save(danhmuc);
        }).orElseGet(()->{
            danhmuc.setIdDanhmuc(id);
           return danhMucRepository.save(danhmuc);
        });
        return updateDanhmuc;
    }

    @Override
    public Boolean deleteDanhMuc(Long id) {
        Boolean exists = danhMucRepository.existsById(id);
        if (exists){
            danhMucRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<tblDanhmuc> optionalGetById(Long id) {
        return danhMucRepository.findById(id);
    }

    @Override
    public tblDanhmuc getById(Long id) {
        return danhMucRepository.findByIdDanhmuc(id);
    }


    @Override
    public List<dtoDanhmuc> findDanhmucConByDanhmucCha() {
        List<dtoDanhmuc> dtoDanhmucs = new ArrayList<>();
        dtoDanhmucs.clear();
        List<tblDanhmuc> findAll = danhMucRepository.findByIdDanhmucChaIsNull();
        findAll.forEach(item->{
            List<tblDanhmuc> danhmuccon = danhMucRepository.findByIdDanhmucCha(item.getIdDanhmuc());
            dtoDanhmucs.add(new dtoDanhmuc(item, danhmuccon));
        });

        return dtoDanhmucs;

    }


    @Override
    public dtoDanhmucAndSanpham findSanphamByDanhmuc(String name) {
        tblDanhmuc danhmuc = danhMucRepository.findByTenDanhMuc(name);
        List<tblSanpham> sanphams = sanPhamRepository.findByIdDanhmucAndIdSanphamChaIsNull(danhmuc.getIdDanhmuc());
        dtoDanhmucAndSanpham dtoDanhmucAndSanpham = new dtoDanhmucAndSanpham(danhmuc , sanphams);

        return dtoDanhmucAndSanpham;
    }



}
