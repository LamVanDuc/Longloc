package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.dtoChiTietSanPham;
import com.example.projectsem2.entity.tblImage;
import com.example.projectsem2.entity.tblSanpham;
import com.example.projectsem2.reponsitory.ImageChiTietSanPhamRepository;
import com.example.projectsem2.reponsitory.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SanPhamServiceImpl implements SanPhamService{
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    ImageChiTietSanPhamRepository imageChiTietSanPhamRepository;
    @Override
    public List<tblSanpham> findAllSanpham() {
        return sanPhamRepository.findByIdSanphamChaNull();
    }

    @Override
    public Optional<tblSanpham> findByid(Long id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public tblSanpham addSanpham(tblSanpham newSanpham) {
        if (newSanpham.getIdSanphamCha()!= null){
            tblSanpham sanpham = sanPhamRepository.findByIdSanpham(newSanpham.getIdSanphamCha());
            newSanpham.setGiaBan(sanpham.getGiaBan());
            newSanpham.setTenSanPham(sanpham.getTenSanPham());
            newSanpham.setImg(sanpham.getImg());
            newSanpham.setIdNhacungcap(sanpham.getIdNhacungcap());
            newSanpham.setIdDanhmuc(sanpham.getIdDanhmuc());
            newSanpham.setTenSanPham(sanpham.getTenSanPham());
            newSanpham.setThuongHieu(sanpham.getThuongHieu());
            return sanPhamRepository.save(newSanpham);
        }
        return sanPhamRepository.save(newSanpham);
    }

    @Override
    public tblSanpham updateSanpham(Long id , tblSanpham newSanpham) {
        if (sanPhamRepository.existsById(id)){
            tblSanpham sanpham = sanPhamRepository.findByIdSanpham(id);
            sanpham.setImg(newSanpham.getImg());
            sanpham.setTenSanPham(newSanpham.getTenSanPham());
            sanpham.setMoTa(newSanpham.getMoTa());
            sanpham.setGiaBan(newSanpham.getGiaBan());
            sanpham.setChatLieu(newSanpham.getChatLieu());
            sanpham.setSoLuong(newSanpham.getSoLuong());
            sanpham.setGiaBan(newSanpham.getGiaBan());
            sanpham.setPhanLoai(newSanpham.getPhanLoai());
            sanpham.setMauSac(newSanpham.getMauSac());
            sanpham.setKichCo(newSanpham.getKichCo());
            sanpham.setNgayChinhSua(GenaricClass.dateTimeNow());
            return sanPhamRepository.save(sanpham);
        }
        return null;
    }

    @Override
    public tblSanpham findSanphamByid(Long id) {
        return sanPhamRepository.findByIdSanpham(id);
    }

    @Override
    public Boolean deleteSanpham(Long id) {
        Boolean exists = sanPhamRepository.existsById(id);
        if (exists){
            sanPhamRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public dtoChiTietSanPham findChitietByIdSanpham(Long id) {
        tblSanpham sanpham = sanPhamRepository.findByIdSanpham(id);
        List<String> color = new ArrayList<>();
        List<String> size = new ArrayList<>();


        List<tblSanpham> chitietsanphams = sanPhamRepository.findByIdSanphamCha(id);
        List<tblImage> images = imageChiTietSanPhamRepository.findByIdSanpham(id);

        for (tblSanpham chiTietSanPham : chitietsanphams){
            if (color.contains(chiTietSanPham.getMauSac())){

            }else {
                color.add(chiTietSanPham.getMauSac());
            }
            if (size.contains(chiTietSanPham.getKichCo())){

            }else {
                size.add(chiTietSanPham.getKichCo());
            }
        }




        dtoChiTietSanPham chiTietSanPham = new dtoChiTietSanPham(sanpham,chitietsanphams,images ,size , color);
        return chiTietSanPham;
    }

    @Override
    public tblSanpham updateSoLuong(Long idSanpham, Long soLuong) {
        tblSanpham sanpham = sanPhamRepository.findByIdSanpham(idSanpham);
        sanpham.setSoLuong((sanpham.getSoLuong() - soLuong));

        return sanPhamRepository.save(sanpham);
    }

    @Override
    public tblSanpham findSanphamByIdSanphamchaAndMausacAndKichco(tblSanpham sanpham) {
        tblSanpham sanpham1 = sanPhamRepository.findByIdSanphamChaAndMauSacAndKichCo(sanpham.getIdSanphamCha(),sanpham.getMauSac() , sanpham.getKichCo());
        return sanpham1;
    }

    @Override
    public List<tblSanpham> findSanPham(String name) {
        List<tblSanpham> sanphams = sanPhamRepository.findByTenSanPhamAndIdSanphamChaIsNull(name);
        return sanphams;
    }


}
