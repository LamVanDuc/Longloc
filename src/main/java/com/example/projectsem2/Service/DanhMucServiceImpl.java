package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.entity.tblDanhmuc;
import com.example.projectsem2.reponsitory.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhMucServiceImpl implements DanhMucService{

    @Autowired
    DanhMucRepository danhMucRepository;

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
        return null;
    }

    @Override
    public Optional<tblDanhmuc> optionalGetById(Long id) {
        return Optional.empty();
    }

    @Override
    public tblDanhmuc getById(Long id) {
        return null;
    }
}
