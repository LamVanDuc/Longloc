package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.entity.tblChitietsanpham;
import com.example.projectsem2.reponsitory.ChiTietSanPhamReponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService{

    @Autowired
    ChiTietSanPhamReponsitory chiTietSanPhamReponsitory;

    @Override
    public List<tblChitietsanpham> getByIdSanPham(Long id) {
        return chiTietSanPhamReponsitory.findByIdSanpham(id);
    }


    @Override
    public tblChitietsanpham addChitietsanpham(tblChitietsanpham chitietsanpham) {
        chitietsanpham.setNgayTao(GenaricClass.dateTimeNow());
        return chiTietSanPhamReponsitory.save(chitietsanpham);
    }

    @Override
    public tblChitietsanpham updateChitietsanpham(Long id, tblChitietsanpham chitietsanpham) {
        tblChitietsanpham updateChitiet = chiTietSanPhamReponsitory.findById(id).map(ctsp ->{
            ctsp.setChatLieu(chitietsanpham.getChatLieu());
            ctsp.setGiaBan(chitietsanpham.getGiaBan());
            ctsp.setNgayChinhSua(GenaricClass.dateTimeNow());
            ctsp.setKichCo(chitietsanpham.getKichCo());
            ctsp.setMauSac(chitietsanpham.getMauSac());
            ctsp.setPhanLoai(chitietsanpham.getPhanLoai());
            ctsp.setSoLuong(chitietsanpham.getSoLuong());
           return chiTietSanPhamReponsitory.save(ctsp);
        }).orElseGet(()->{
            chitietsanpham.setNgayTao(GenaricClass.dateTimeNow());
            return chiTietSanPhamReponsitory.save(chitietsanpham);
        });
        return updateChitiet;
    }

    @Override
    public Boolean deleteChitietsanpham(Long id) {
        Boolean exists = chiTietSanPhamReponsitory.existsById(id);
        if (exists){
            chiTietSanPhamReponsitory.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Optional<tblChitietsanpham> optionalGetById(Long id) {
        Optional<tblChitietsanpham> chitietsanpham = chiTietSanPhamReponsitory.findById(id);
        if (chitietsanpham.isEmpty()){
            return Optional.empty();
        }else {
            return chitietsanpham;
        }
    }

    @Override
    public tblChitietsanpham getById(Long id) {

        Boolean exists = chiTietSanPhamReponsitory.existsById(id);
        if (exists){
            return chiTietSanPhamReponsitory.findByIdChitietsanpham(id);
        }else {
            return null;
        }
    }
}
