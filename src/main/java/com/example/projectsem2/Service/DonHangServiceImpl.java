package com.example.projectsem2.Service;

import com.example.projectsem2.dto.dtoChiTietDonHang;
import com.example.projectsem2.dto.dtoChitietsanphamAndChitietdonhang;
import com.example.projectsem2.entity.tblChitietdonhang;
import com.example.projectsem2.entity.tblChitietsanpham;
import com.example.projectsem2.entity.tblDonhang;
import com.example.projectsem2.entity.tblSanpham;
import com.example.projectsem2.reponsitory.ChiTietDonHangReponsitory;
import com.example.projectsem2.reponsitory.ChiTietSanPhamReponsitory;
import com.example.projectsem2.reponsitory.DonHangRepository;
import com.example.projectsem2.reponsitory.SanPhamRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DonHangServiceImpl implements DonHangService{
    @Autowired
    DonHangRepository donHangRepository;

    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    ChiTietSanPhamReponsitory chiTietSanPhamReponsitory;

    @Autowired
    ChiTietDonHangReponsitory chiTietDonHangReponsitory;

    @Override
    public dtoChiTietDonHang getByIdDonHang(String id) throws RuntimeException, NotFoundException {
        tblDonhang donhang = donHangRepository.findByIdDonhang(id);
        dtoChiTietDonHang dtoChiTietDonHang = new dtoChiTietDonHang();
        List<dtoChitietsanphamAndChitietdonhang> chitiet = new ArrayList<>();

        if (donhang==null){

            throw new NotFoundException("Không tìm thấy Đơn Hàng");
        }else{

            // gắn đơn hàng vào
            dtoChiTietDonHang.setDonhang(donhang);
            //tìm chi tiết đơn hàng thuộc đơn hàng nào
            List<tblChitietdonhang> chitietdonhang = chiTietDonHangReponsitory.findByIdDonhang(donhang.getIdDonhang());

            //duyệt tất cả chi tiết đơn hàng tìm được
            for (tblChitietdonhang  item: chitietdonhang){
                //tìm chi tiết sản phẩm thộc chi tiết đơn hàng nào
                tblChitietsanpham chitietsanphams = chiTietSanPhamReponsitory.findByIdChitietsanpham(item.getIdChitietsanpham());
                //chi tiết sản phẩm thuộc sản phẩm nào
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietsanphams.getIdSanpham());

                // gắn vào list gồm có chi tiết đơn hàng , chi tiết sản phẩm , sản phẩm
                dtoChitietsanphamAndChitietdonhang chitietsanphamAndChitietdonhang = new dtoChitietsanphamAndChitietdonhang(item,sanpham,chitietsanphams);
                //  add ngược lại list
                chitiet.add(chitietsanphamAndChitietdonhang);
            }

            // list này biết được đơn hàng , có chi tiết đơn hàng nào , chi tiết sản phẩm thuộc sản phẩm nào
            dtoChiTietDonHang.setChitietsanphamAndChitietdonhang(chitiet);
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
