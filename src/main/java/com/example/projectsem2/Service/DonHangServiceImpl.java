package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.giohang.donhang.dtoChiTietDonHang;
import com.example.projectsem2.dto.dtoSanphamAndChitietdonhang;
import com.example.projectsem2.dto.giohang.donhang.dtoChiTietDonHang2;
import com.example.projectsem2.entity.*;
import com.example.projectsem2.reponsitory.ChiTietDonHangRepository;
import com.example.projectsem2.reponsitory.DiaChiGiaoHangReponsitory;
import com.example.projectsem2.reponsitory.DonHangRepository;
import com.example.projectsem2.reponsitory.SanPhamRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DonHangServiceImpl implements DonHangService{
    @Autowired
    DonHangRepository donHangRepository;
    @Autowired
    SanPhamRepository sanPhamRepository;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    GioHangService gioHangService;
    @Autowired
    DiaChiGiaoHangService diaChiGiaoHangService;

    @Autowired
    DiaChiGiaoHangReponsitory diaChiGiaoHangReponsitory;

    @Autowired
    ChiTietDonHangRepository chiTietDonHangRepository;
    @Autowired
    NguoiDungService nguoiDungService;




    @Override
    public dtoChiTietDonHang getByIdDonHang(String id) throws RuntimeException, NotFoundException {
        tblDonhang donhang = donHangRepository.findByIdDonhang(id);
        dtoChiTietDonHang dtoChiTietDonHang = new dtoChiTietDonHang();
        List<dtoSanphamAndChitietdonhang> chitiet = new ArrayList<>();

        if (donhang==null){

            throw new NotFoundException("Không tìm thấy Đơn Hàng");
        }else{

            // gắn đơn hàng vào
            dtoChiTietDonHang.setDonhang(donhang);
            //tìm chi tiết đơn hàng thuộc đơn hàng nào
            List<tblChitietdonhang> chitietdonhang = chiTietDonHangRepository.findByIdDonhang(donhang.getIdDonhang());

            //duyệt tất cả chi tiết đơn hàng tìm được
            for (tblChitietdonhang  item: chitietdonhang){
                //tìm chi tiết sản phẩm thộc chi tiết đơn hàng nào
//                tblChitietsanpham chitietsanphams = chiTietSanPhamReponsitory.findByIdChitietsanpham(item.getIdChitietsanpham());
                //chi tiết sản phẩm thuộc sản phẩm nào
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(item.getIdSanpham());

                // gắn vào list gồm có chi tiết đơn hàng , chi tiết sản phẩm , sản phẩm
                dtoSanphamAndChitietdonhang chitietsanphamAndChitietdonhang = new dtoSanphamAndChitietdonhang(item,sanpham);
                //  add ngược lại list
                chitiet.add(chitietsanphamAndChitietdonhang);
            }

            // list này biết được đơn hàng , có chi tiết đơn hàng nào , chi tiết sản phẩm thuộc sản phẩm nào
            dtoChiTietDonHang.setChitietsanphamAndChitietdonhang(chitiet);
            return dtoChiTietDonHang;
        }
    }

    @Override
    public Optional<tblDonhang> findDonhangByIdDonHang(String id) {
        Optional<tblDonhang> donhang = donHangRepository.findById(id);
        return donhang;
    }

    @Override
    public List<tblDonhang> getAll() {
        return donHangRepository.findAll();
    }

    @Override
    public tblDonhang updateDonHang(String id, tblDonhang newTblDonhang) {
        return null;
    }

    @Override
    public Boolean deleteDonHang(String id) {
        Boolean exists = donHangRepository.existsById(id);
        if (exists){
            donHangRepository.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

    @Override
    @Transactional
    public tblDonhang themDonHangWithGioHang(tblDonhang newDonhang) throws RuntimeException {
        List<tblGiohang> tblGiohangList =GioHangServiceImpl.giohangs;
        try{
            String ghitru;
            String idDonhang = GenaricClass.idDonHang();
            if (newDonhang.getGhiChu().isEmpty()){
                ghitru = "Không có ghi trú";
            }else {
                ghitru = newDonhang.getGhiChu();
            }
            tblDonhang donhang = new tblDonhang(
                    idDonhang ,
                    nguoiDungService.idNguoidung(),
                    newDonhang.getIdDiachigiaohang(),
                   ghitru,
                    GenaricClass.TRANGTHAI_dangCho,
                    GenaricClass.dateTimeNow(),
                    GenaricClass.dateTimeNow(),
                    GenaricClass.dayLater(5));
            tblDonhang  responseDonhang = donHangRepository.save(donhang);

            for (tblGiohang giohang : tblGiohangList) {
                //lấy ra sản phẩm giỏ hàng
                Optional<tblSanpham> chitietsanpham = sanPhamRepository.findById(giohang.getIdSanpham());
                // check giỏ hàng tồn tại không
                if (chitietsanpham.isPresent()){
                    // check số lượng trong sản phẩm có đủ không ?
                    if (chitietsanpham.get().getSoLuong()>= giohang.getSoLuong()) {
                        // thêm vào chi tiết đơn hàng
                        chiTietDonHangRepository.save(new tblChitietdonhang(
                                idDonhang,
                                giohang.getIdSanpham(),
                                giohang.getSoLuong(),
                                giohang.getGia(),
                               GenaricClass.dateTimeNow()));
                        // xóa giỏ hàng nếu đã mua thành công
                        gioHangService.deleteGiohang(giohang.getIdGiohang());
                        // update lại số lượng sau khi mua thành công
                        sanPhamService.updateSoLuong(giohang.getIdSanpham(), giohang.getSoLuong());
                    }else {
                        // nếu số lượng không đủ sẽ throw ra Exception
                        throw new RuntimeException("Số lượng sản phẩm không đủ !");
                    }
                }
            }

            return responseDonhang;
        }catch (Exception ex){
            throw new RuntimeException("đã sảy ra lỗi : "+ex.getMessage());
        }
    }

    @Override
    public List<tblChitietdonhang> findChitietdonhangByIddonhang(String idDonhang) {
        List<tblChitietdonhang> chitietdonhangs = chiTietDonHangRepository.findByIdDonhang(idDonhang);
        return chitietdonhangs;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiDaNhan() {
        List<tblDonhang> donhangList =  donHangRepository.findByTrangThai(GenaricClass.TRANGTHAI_daNhanHang);
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDaNhan(){

        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidungAndTrangThai(nguoiDungService.idNguoidung(),GenaricClass.TRANGTHAI_daNhanHang);
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiChoXacNhan() {

        List<tblDonhang> donhangList = donHangRepository.findByTrangThai(GenaricClass.TRANGTHAI_dangCho);
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiChoXacNhan() {

        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidungAndTrangThai(nguoiDungService.idNguoidung(),GenaricClass.TRANGTHAI_dangCho);
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiDangGiao() {


        List<tblDonhang> donhangList =  donHangRepository.findByTrangThai(GenaricClass.TRANGTHAI_dangGiao);
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDangGiao() {

        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidungAndTrangThai(nguoiDungService.idNguoidung(),GenaricClass.TRANGTHAI_dangGiao);
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiHuydonhang() {

        List<tblDonhang> donhangList =  donHangRepository.findByTrangThai(GenaricClass.TRANGTHAI_huydonhang);
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }




    @Override
    public dtoChiTietDonHang2 finDonhang(String id) {

        Optional<tblDonhang> donhang =  donHangRepository.findByIdDonhangAndIdNguoidung(id,nguoiDungService.idNguoidung());

        if (donhang.equals(null)){
            throw new RuntimeException("đơn hàng không tồn tại");
        }
        Optional<tblDiachigiaohang> diachigiaohang = diaChiGiaoHangService.findDiachigiaohang(donhang.get().getIdDiachigiaohang());
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(donhang.get().getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
        dtoChiTietDonHang2 dtoChiTietDonHang = new dtoChiTietDonHang2(donhang.get(), sanphamAndChitietdonhangs , diachigiaohang);
        return dtoChiTietDonHang;
    }

    @Override
    public dtoChiTietDonHang2 finDonhangAdmin(String id) {

        Optional<tblDonhang> donhang =  donHangRepository.findById(id);

        if (donhang.equals(null)){
            throw new RuntimeException("đơn hàng không tồn tại");
        }
        Optional<tblDiachigiaohang> diachigiaohang = diaChiGiaoHangReponsitory.findById(donhang.get().getIdDiachigiaohang());
        List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(donhang.get().getIdDonhang());
        List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
        for (tblChitietdonhang chitietdonhang : chitietdonhangList){
            tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
            sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
        }
        dtoChiTietDonHang2 dtoChiTietDonHang = new dtoChiTietDonHang2(donhang.get(), sanphamAndChitietdonhangs , diachigiaohang);
        return dtoChiTietDonHang;
    }




    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiHuydonhang() {
        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidungAndTrangThai(nguoiDungService.idNguoidung() , GenaricClass.TRANGTHAI_huydonhang);
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }

    @Override
    public List<dtoChiTietDonHang> findAllDonHangByNguoidung() {

        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidung(nguoiDungService.idNguoidung());
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }

    @Override
    public List<dtoChiTietDonHang> findAllDonHang() {

        List<tblDonhang> donhangList = donHangRepository.findAll();
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }

    @Override
    public boolean nhanGiaoDonhang(String id) {
        tblDonhang donhang = donHangRepository.findByIdDonhang(id);
        if (donhang.getTrangThai().equals(GenaricClass.TRANGTHAI_daXacNhan)){
            donhang.setTrangThai(GenaricClass.TRANGTHAI_dangGiao);
            donhang.setNgayChinhSua(GenaricClass.dateTimeNow());
            donHangRepository.save(donhang);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean duyetDonhang(String id) {
        tblDonhang donhang = donHangRepository.findByIdDonhang(id);
        if (donhang.getTrangThai().equals(GenaricClass.TRANGTHAI_dangCho)){
            donhang.setTrangThai(GenaricClass.TRANGTHAI_daXacNhan);
            donhang.setNgayChinhSua(GenaricClass.dateTimeNow());
            donHangRepository.save(donhang);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean huyDonhang(String id) {
        tblDonhang donhang = donHangRepository.findByIdNguoidungAndIdDonhang(nguoiDungService.idNguoidung(),id);
        if (donhang.getTrangThai().equals(GenaricClass.TRANGTHAI_dangCho)){
            donhang.setTrangThai(GenaricClass.TRANGTHAI_huydonhang);
            donhang.setNgayChinhSua(GenaricClass.dateTimeNow());
            donHangRepository.save(donhang);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean daNhanDonhang(String id) {
        tblDonhang donhang = donHangRepository.findByIdNguoidungAndIdDonhang(nguoiDungService.idNguoidung(),id );
        if (donhang.getTrangThai().equals(GenaricClass.TRANGTHAI_dangGiao)){
            donhang.setTrangThai(GenaricClass.TRANGTHAI_daNhanHang);
            donhang.setNgayChinhSua(GenaricClass.dateTimeNow());
            donHangRepository.save(donhang);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean mualaidonhang(String idDonhang) {
        GioHangServiceImpl.giohangs.clear();
        Optional<tblDonhang> donhang = findDonhangByIdDonHang(idDonhang);
        if (donhang.isEmpty()){
            throw new RuntimeException("Không tìm thấy đơn hàng");
        }else {
            List<tblChitietdonhang> chitietdonhang = chiTietDonHangRepository.findByIdDonhang(donhang.get().getIdDonhang());
            chitietdonhang.forEach(item->{
                tblGiohang giohang = gioHangService.addGioHang(new tblGiohang(item.getIdSanpham() , item.getSoLuong()));
                GioHangServiceImpl.giohangs.add(giohang);
            });
            return true;
        }
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiChoNhanGiao() {
        List<tblDonhang> donhangList =  donHangRepository.findByTrangThai( GenaricClass.TRANGTHAI_daXacNhan);
        List<dtoChiTietDonHang> donHangs = new ArrayList<>();

        for (tblDonhang item: donhangList) {
            List<tblChitietdonhang> chitietdonhangList = chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            List<dtoSanphamAndChitietdonhang> sanphamAndChitietdonhangs = new ArrayList<>();
            for (tblChitietdonhang chitietdonhang : chitietdonhangList){
                tblSanpham sanpham = sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                sanphamAndChitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));
            }
            donHangs.add(new dtoChiTietDonHang(item , sanphamAndChitietdonhangs));
        }
        return donHangs;
    }


}
