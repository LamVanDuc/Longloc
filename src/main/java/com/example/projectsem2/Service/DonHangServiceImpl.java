package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.donhang.dtoChiTietDonHang;
import com.example.projectsem2.dto.dtoSanphamAndChitietdonhang;
import com.example.projectsem2.entity.*;
import com.example.projectsem2.reponsitory.ChiTietDonHangRepository;
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
    ChiTietDonHangRepository chiTietDonHangRepository;




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
                    GenaricClass.idNguoidung(),
                    newDonhang.getIdDiachigiaohang(),
                   ghitru,
                    GenaricClass.TRANGTHAI_dangCho,
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
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDaNhan(){

        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidungAndTrangThai(GenaricClass.idNguoidung(),GenaricClass.TRANGTHAI_daNhanHang);
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiChoXacNhan() {

        List<tblDonhang> donhangList = donHangRepository.findByTrangThai(GenaricClass.TRANGTHAI_dangCho);
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiChoXacNhan() {

        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidungAndTrangThai(GenaricClass.idNguoidung(),GenaricClass.TRANGTHAI_dangCho);
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiDangGiao() {

        List<tblDonhang> donhangList =  donHangRepository.findByTrangThai(GenaricClass.TRANGTHAI_dangGiao);
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDangGiao() {

        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidungAndTrangThai(GenaricClass.idNguoidung(),GenaricClass.TRANGTHAI_dangGiao);
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public List<dtoChiTietDonHang> findAllTrangthaiHuydonhang() {

        List<tblDonhang> donhangList =  donHangRepository.findByTrangThai(GenaricClass.TRANGTHAI_huydonhang);
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiHuydonhang() {
        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidungAndTrangThai(GenaricClass.idNguoidung() , GenaricClass.TRANGTHAI_huydonhang);
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public List<dtoChiTietDonHang> findAllDonHangByNguoidung() {

        List<tblDonhang> donhangList =  donHangRepository.findByIdNguoidung(GenaricClass.idNguoidung());
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public List<dtoChiTietDonHang> findAllDonHang() {

        List<tblDonhang> donhangList = donHangRepository.findAll();
        List<dtoChiTietDonHang> chitietDonhang = new ArrayList<dtoChiTietDonHang>();
        List<dtoSanphamAndChitietdonhang> chitietdonhangs =new ArrayList<>();
        donhangList.forEach(item->{
            List<tblChitietdonhang> dtoChitietDonhangs =chiTietDonHangRepository.findByIdDonhang(item.getIdDonhang());
            dtoChitietDonhangs.forEach(chitietdonhang->{
                tblSanpham sanpham =sanPhamRepository.findByIdSanpham(chitietdonhang.getIdSanpham());
                chitietdonhangs.add(new dtoSanphamAndChitietdonhang(chitietdonhang , sanpham));

            });
            chitietDonhang.add( new dtoChiTietDonHang(item , chitietdonhangs));
        });

        return chitietDonhang;
    }

    @Override
    public boolean nhanGiaoDonhang(String id) {
        tblDonhang donhang = donHangRepository.findByIdDonhang(id);
        if (donhang.getTrangThai().equals(GenaricClass.TRANGTHAI_daNhanHang)){
            donhang.setTrangThai(GenaricClass.TRANGTHAI_dangGiao);
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
            donHangRepository.save(donhang);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean huyDonhang(String id) {
        tblDonhang donhang = donHangRepository.findByIdNguoidungAndIdDonhang(GenaricClass.idNguoidung(),id);
        if (donhang.getTrangThai().equals(GenaricClass.TRANGTHAI_dangCho)){
            donhang.setTrangThai(GenaricClass.TRANGTHAI_huydonhang);
            donHangRepository.save(donhang);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean daNhanDonhang(String id) {
        tblDonhang donhang = donHangRepository.findByIdNguoidungAndIdDonhang(GenaricClass.idNguoidung(),id );
        if (donhang.getTrangThai().equals(GenaricClass.TRANGTHAI_dangGiao)){
            donhang.setTrangThai(GenaricClass.TRANGTHAI_daNhanHang);
            donHangRepository.save(donhang);
            return true;
        }else {
            return false;
        }
    }
}
