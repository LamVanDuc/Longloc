package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.dtoGioHangAndChiTietSanPham;
import com.example.projectsem2.entity.tblGiohang;
import com.example.projectsem2.entity.tblSanpham;
import com.example.projectsem2.reponsitory.GioHangReponsitory;
import com.example.projectsem2.reponsitory.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GioHangServiceImpl implements GioHangService{

    static List<tblGiohang> giohangs = new ArrayList<tblGiohang>();
    @Autowired
    GioHangReponsitory gioHangReponsitory;
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Override
    public List<dtoGioHangAndChiTietSanPham> getByIdNguoidung() {
        List<dtoGioHangAndChiTietSanPham> find = new ArrayList<>();
        List<tblGiohang> giohangList = gioHangReponsitory.findByIdNguoidung(GenaricClass.idNguoidung());
        for (tblGiohang giohang: giohangList) {
           tblSanpham sanpham = sanPhamRepository.findByIdSanpham(giohang.getIdSanpham());
           find.add(new dtoGioHangAndChiTietSanPham(giohang , sanpham));
        }
        return  find;
    }

    @Override
    public tblGiohang addGioHang(tblGiohang newGiohang) throws RuntimeException{
        newGiohang.setIdNguoidung(GenaricClass.idNguoidung());
//        tblChitietsanpham chitietsanpham = chiTietSanPhamReponsitory.findByIdChitietsanpham(newGiohang.getIdChitietsanpham());
        tblSanpham sanpham = sanPhamRepository.findByIdSanpham(newGiohang.getIdSanpham());
        if (gioHangReponsitory.existsByIdSanpham(newGiohang.getIdSanpham())){
            tblGiohang giohang = gioHangReponsitory.findByIdNguoidungAndIdSanpham(GenaricClass.idNguoidung() , newGiohang.getIdSanpham());
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
    @Transactional
    public tblGiohang updateGiohang(Long id,tblGiohang newGiohang) throws RuntimeException{

        tblGiohang findGiohang = gioHangReponsitory.findById(id).map(gh ->{
            if (newGiohang.getSoLuong() > 0){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(gh.getIdSanpham());
                if (sanpham.getSoLuong() >=(newGiohang.getSoLuong())){
                    gh.setGia(sanpham.getGiaBan());
                    gh.setSoLuong(newGiohang.getSoLuong());
                    return gioHangReponsitory.save(gh);
                }else {
                    throw new RuntimeException("Số thêm vào giỏ lớn hơn số lượng sản phẩm có !");
                }
            }else {
                throw new RuntimeException("Số lượng phải lớn hơn 0");
            }
        }).orElseGet(()->{
            throw new RuntimeException("không tìm thấy giỏ hàng");
        });
        return findGiohang;
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


    @Override
    public List<tblGiohang> muaGiohang(List<Long> idGioHang){
        giohangs.clear();
        for (Long id : idGioHang){
            tblGiohang giohang = gioHangReponsitory.findByIdGiohang(id);
            giohangs.add(giohang);
        }
        return giohangs;
    }


    public List<dtoGioHangAndChiTietSanPham> loadDathang() {
        List<dtoGioHangAndChiTietSanPham> dtoGioHangList = new ArrayList<dtoGioHangAndChiTietSanPham>();
        dtoGioHangList.clear();
        for (tblGiohang item: giohangs) {
//            tblChitietsanpham chitietsanpham = chiTietSanPhamReponsitory.findByIdChitietsanpham(item.getIdChitietsanpham());
            tblSanpham sanpham = sanPhamRepository.findByIdSanpham(item.getIdSanpham());
            dtoGioHangList.add( new dtoGioHangAndChiTietSanPham(item , sanpham));
        }
        return dtoGioHangList;
    }



}
