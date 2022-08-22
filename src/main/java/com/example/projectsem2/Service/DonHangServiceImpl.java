package com.example.projectsem2.Service;

import com.example.projectsem2.dto.dtoChiTietDonHang;
import com.example.projectsem2.dto.dtoChitietsanphamAndChitietdonhang;
import com.example.projectsem2.entity.tblChitietdonhang;
import com.example.projectsem2.entity.tblChitietsanpham;
import com.example.projectsem2.entity.tblDonhang;
import com.example.projectsem2.reponsitory.ChiTietDonHangReponsitory;
import com.example.projectsem2.reponsitory.ChiTietSanPhamReponsitory;
import com.example.projectsem2.reponsitory.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonHangServiceImpl implements DonHangService{
    @Autowired
    DonHangRepository donHangRepository;

    @Autowired
    ChiTietSanPhamReponsitory chiTietSanPhamReponsitory;

    @Autowired
    ChiTietDonHangReponsitory chiTietDonHangReponsitory;

    @Override
    public dtoChiTietDonHang getByIdDonHang(String id) throws RuntimeException {
        tblDonhang donhang = donHangRepository.findByIdDonhang(id);
        dtoChiTietDonHang dtoChiTietDonHang = null;
        List<dtoChitietsanphamAndChitietdonhang> chitietsanphamAndChitietdonhangList = new ArrayList<>();

        if (donhang==null){
            throw new RuntimeException("Không tìm thấy Đơn Hàng");
        }else {

            dtoChiTietDonHang.setDonhang(donhang);
            List<tblChitietdonhang> chitietdonhang = chiTietDonHangReponsitory.findByIdDonhang(donhang.getIdDonhang());

            for (tblChitietdonhang  item: chitietdonhang){
                tblChitietsanpham chitietsanphams = chiTietSanPhamReponsitory.findByIdChitietsanpham(item.getIdChitietsanpham());
                dtoChitietsanphamAndChitietdonhang chitietsanphamAndChitietdonhang = new dtoChitietsanphamAndChitietdonhang(item,chitietsanphams);
                chitietsanphamAndChitietdonhangList.add(chitietsanphamAndChitietdonhang);
            }
            dtoChiTietDonHang.setChitietsanphamAndChitietdonhang(chitietsanphamAndChitietdonhangList);
            return dtoChiTietDonHang;
        }
    }

    @Override
    public tblDonhang findDonhangByIdDonHang(String id) {
        return null;
    }

    @Override
    public List<tblDonhang> getAll() {
        return null;
    }

    @Override
    public tblDonhang updateDonHang(String id, tblDonhang newTblDonhang) {
        return null;
    }

    @Override
    public Boolean deleteDonHang(String id) {
        return null;
    }

    @Override
    public tblDonhang themDonHangWithGioHang(tblDonhang newDonhang) throws RuntimeException {
        return null;
    }

    @Override
    public List<tblChitietdonhang> findByChitietDonhang(Long idChitietdonhang) {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiDaNhan() {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDaNhan() {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiChoXacNhan() {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiChoXacNhan() {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiDangGiao() {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDangGiao() {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiHuydonhang() {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiHuydonhang() {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findAllDonHangUser() {
        return null;
    }

    @Override
    public List<dtoChiTietDonHang> findAllDonHang() {
        return null;
    }

    @Override
    public boolean daNhanHang(String id) {
        return false;
    }

    @Override
    public boolean duyetDonhang(String id) {
        return false;
    }

    @Override
    public boolean huyDonhang(String id) {
        return false;
    }

    @Override
    public boolean daNhanDonhang(String id) {
        return false;
    }
}
