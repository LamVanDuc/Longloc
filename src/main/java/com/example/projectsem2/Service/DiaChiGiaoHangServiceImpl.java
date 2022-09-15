package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.entity.tblDiachigiaohang;
import com.example.projectsem2.reponsitory.DiaChiGiaoHangReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiaChiGiaoHangServiceImpl implements DiaChiGiaoHangService{

    @Autowired
    DiaChiGiaoHangReponsitory diaChiGiaoHangReponsitory;
    @Autowired
    NguoiDungService nguoiDungService;

    @Override
    public List<tblDiachigiaohang> findByIdNguoidung() {
        return diaChiGiaoHangReponsitory.findByIdNguoidung(nguoiDungService.idNguoidung());
    }

    @Override
    public tblDiachigiaohang findByMac_Dinh() throws RuntimeException{
        try{
            return diaChiGiaoHangReponsitory.findByIdNguoidungAndMacDinh(nguoiDungService.idNguoidung() , GenaricClass.MACDINH_true);
        }catch (Exception ex){
            throw new RuntimeException("đã sảy ra lỗi : "+ex.getLocalizedMessage());
        }

    }

    @Override
    public Optional<tblDiachigiaohang> findById(Long id) {
        Optional<tblDiachigiaohang> diachigiaohang = diaChiGiaoHangReponsitory.findById(id);
        return diachigiaohang;
    }

    @Override
    public tblDiachigiaohang findDiachigiaohang(Long id) {
        Optional<tblDiachigiaohang> diachigiaohang = diaChiGiaoHangReponsitory.findByIdDiachigiaohangAndIdNguoidung(id , nguoiDungService.idNguoidung());

        if (diachigiaohang.isEmpty()){throw new RuntimeException("Không tồn tại địa chỉ giao hàng");}
        tblDiachigiaohang diachigiaohang1 = diachigiaohang.get();
        return diachigiaohang1;
    }

    @Override
    public tblDiachigiaohang changeDiaChiGiaoHang(Long id) throws RuntimeException{

        try{
            tblDiachigiaohang find = diaChiGiaoHangReponsitory.findByIdNguoidungAndMacDinh(nguoiDungService.idNguoidung() , GenaricClass.MACDINH_true);
            tblDiachigiaohang diachigiaohang1 = diaChiGiaoHangReponsitory.findById(find.getIdDiachigiaohang()).map(dchi->{
                dchi.setMacDinh(GenaricClass.MACDINH_false);
                return  diaChiGiaoHangReponsitory.save(dchi);
            }).orElseThrow(()-> new RuntimeException("đã sảy ra lỗi , update trạng thái false không thành công"));



            tblDiachigiaohang diachigiaohangfalse = diachigiaohang1;



            tblDiachigiaohang diachigiaohang = diaChiGiaoHangReponsitory.findByIdDiachigiaohang(id).map(dc->{
                dc.setMacDinh(GenaricClass.MACDINH_true);
                return diaChiGiaoHangReponsitory.save(dc);
            }).orElseThrow(()-> new RuntimeException("đã xảy ra lỗi , update trạng thái true không thành công ."));


            tblDiachigiaohang diachigiaohangTrue = diachigiaohang;

            return diachigiaohangTrue;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }


    @Override
    public tblDiachigiaohang add(tblDiachigiaohang diachigiaohang) {
        try{
            boolean check = diaChiGiaoHangReponsitory.existsByIdNguoidungAndMacDinh(nguoiDungService.idNguoidung() , GenaricClass.MACDINH_true);
            if (check) {
                diachigiaohang.setIdNguoidung(nguoiDungService.idNguoidung());
                diachigiaohang.setMacDinh(GenaricClass.MACDINH_false);
                diachigiaohang.setNgayTao(GenaricClass.dateTimeNow());
                return diaChiGiaoHangReponsitory.save(diachigiaohang);
            }else {
                diachigiaohang.setIdNguoidung(nguoiDungService.idNguoidung());
                diachigiaohang.setMacDinh(GenaricClass.MACDINH_true);
                diachigiaohang.setNgayTao(GenaricClass.dateTimeNow());
                return diaChiGiaoHangReponsitory.save(diachigiaohang);
            }
        }catch (Exception ex){
            throw new RuntimeException("đã sảy ra lỗi :"+ex.getMessage());
        }
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
            newDiachigiaohang.setIdNguoidung(nguoiDungService.idNguoidung());
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
