package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.entity.tblDiachigiaohang;
import com.example.projectsem2.reponsitory.DiaChiGiaoHangReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DiaChiGiaoHangServiceImpl implements DiaChiGiaoHangService{

    @Autowired
    DiaChiGiaoHangReponsitory diaChiGiaoHangReponsitory;

    @Override
    public List<tblDiachigiaohang> findByIdNguoidung() {
        return diaChiGiaoHangReponsitory.findByIdNguoidung(GenaricClass.idNguoidung());
    }

    @Override
    public tblDiachigiaohang add(tblDiachigiaohang diachigiaohang) {
        diachigiaohang.setIdNguoidung(GenaricClass.idNguoidung());
        diachigiaohang.setNgayTao(GenaricClass.dateTimeNow());
        return diaChiGiaoHangReponsitory.save(diachigiaohang);
    }

    @Override
    public tblDiachigiaohang update(Long id, tblDiachigiaohang newDiachigiaohang) {
        tblDiachigiaohang diachigiaohang = diaChiGiaoHangReponsitory.findById(id).map(dc->{
            dc.setDiaChi(newDiachigiaohang.getDiaChi());
            dc.setDienThoai(newDiachigiaohang.getDienThoai());
            dc.setTenNguoiNhan(newDiachigiaohang.getTenNguoiNhan());
            dc.setNgayChinhSua(GenaricClass.dateTimeNow());
            return diaChiGiaoHangReponsitory.save(dc);
        }).orElseGet(()->{
            newDiachigiaohang.setIdDiachigiaohang(id);
            newDiachigiaohang.setIdNguoidung(GenaricClass.idNguoidung());
            newDiachigiaohang.setNgayTao(GenaricClass.dateTimeNow());
            return diaChiGiaoHangReponsitory.save(newDiachigiaohang);
        });
        return diachigiaohang;
    }

    @Override
    public Boolean delete(Long id) {
        Boolean exists = diaChiGiaoHangReponsitory.existsById(id);
        if(exists){
            diaChiGiaoHangReponsitory.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
