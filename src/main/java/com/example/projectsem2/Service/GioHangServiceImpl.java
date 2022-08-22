package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.dtoGioHangAndChiTietSanPham;
import com.example.projectsem2.entity.tblChitietsanpham;
import com.example.projectsem2.entity.tblGiohang;
import com.example.projectsem2.entity.tblSanpham;
import com.example.projectsem2.reponsitory.ChiTietSanPhamReponsitory;
import com.example.projectsem2.reponsitory.GioHangReponsitory;
import com.example.projectsem2.reponsitory.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GioHangServiceImpl implements GioHangService{

    @Autowired
    GioHangReponsitory gioHangReponsitory;
    @Autowired
    ChiTietSanPhamReponsitory chiTietSanPhamReponsitory;
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<dtoGioHangAndChiTietSanPham> getByIdNguoidung() {
        List<dtoGioHangAndChiTietSanPham> find = new ArrayList<>();
        List<tblGiohang> giohangList = gioHangReponsitory.findByIdNguoidung(GenaricClass.idNguoidung());
        for (tblGiohang giohang: giohangList) {
           tblChitietsanpham chitietsanpham =  chiTietSanPhamReponsitory.findByIdChitietsanpham(giohang.getIdChitietsanpham());
           tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietsanpham.getIdSanpham());
           find.add(new dtoGioHangAndChiTietSanPham(giohang , sanpham , chitietsanpham));
        }
        return  find;
    }

    @Override
    public tblGiohang addGioHang(tblGiohang newGiohang) throws RuntimeException{
        newGiohang.setIdNguoidung(GenaricClass.idNguoidung());
        tblChitietsanpham sanpham = chiTietSanPhamReponsitory.findByIdChitietsanpham(newGiohang.getIdChitietsanpham());
        if (gioHangReponsitory.existsByIdChitietsanpham(newGiohang.getIdChitietsanpham())){
            tblGiohang giohang = gioHangReponsitory.findByIdNguoidungAndIdChitietsanpham(GenaricClass.idNguoidung() , newGiohang.getIdChitietsanpham());
            giohang.setGia(sanpham.getGiaBan());
            if (sanpham.getSoLuong() >= (giohang.getSoLuong() + newGiohang.getSoLuong())){
                giohang.setSoLuong(giohang.getSoLuong()+ newGiohang.getSoLuong());
                return gioHangReponsitory.save(giohang);
            }else {
                throw new RuntimeException("Số trong giỏ và thêm vào lớn hơn số lượng sản phẩm có !");
            }
        }else{
            if (sanpham.getSoLuong() >=newGiohang.getSoLuong()){
                newGiohang.setGia(sanpham.getGiaBan());
                return gioHangReponsitory.save(newGiohang);
            }else {
                throw new RuntimeException("Số thêm vào giỏ lớn hơn số lượng sản phẩm có !");
            }
        }
    }

    @Override
    public tblGiohang updateGiohang(Long id,tblGiohang newGiohang) throws RuntimeException{
        tblChitietsanpham sanpham = chiTietSanPhamReponsitory.findByIdChitietsanpham(newGiohang.getIdChitietsanpham());
        tblGiohang find = gioHangReponsitory.findById(id).map(gh ->{
            if (sanpham.getSoLuong() >=newGiohang.getSoLuong()){
                newGiohang.setGia(sanpham.getGiaBan());
                return gioHangReponsitory.save(newGiohang);
            }else {
                throw new RuntimeException("Số thêm vào giỏ lớn hơn số lượng sản phẩm có !");
            }
        }).orElseGet(()->{
            if (sanpham.getSoLuong() >=newGiohang.getSoLuong()) {
                newGiohang.setIdGiohang(id);
                return gioHangReponsitory.save(newGiohang);
            }else {
                throw new RuntimeException("Số thêm vào giỏ lớn hơn số lượng sản phẩm có !");
            }
        });
        return find;
    }

    @Override
    public Boolean deleteGiohang(Long id) {
        Boolean exists = gioHangReponsitory.existsById(id);
        if (exists){
            gioHangReponsitory.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<tblGiohang> getById(Long id) {
        Optional<tblGiohang> giohang = gioHangReponsitory.findById(id);
        if (giohang.isPresent()){
            return giohang;
        }else {
            return Optional.empty();
        }
    }
}
