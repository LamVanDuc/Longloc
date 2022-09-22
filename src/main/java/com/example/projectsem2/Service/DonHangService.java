package com.example.projectsem2.Service;

import com.example.projectsem2.dto.giohang.donhang.dtoChiTietDonHang;
import com.example.projectsem2.dto.giohang.donhang.dtoChiTietDonHang2;
import com.example.projectsem2.entity.tblChitietdonhang;
import com.example.projectsem2.entity.tblDonhang;
import javassist.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.Optional;

public interface DonHangService {

    dtoChiTietDonHang getByIdDonHang(String id) throws NotFoundException;

    Optional<tblDonhang> findDonhangByIdDonHang(String id);

    List<tblDonhang> getAll();

    tblDonhang updateDonHang(String id, tblDonhang newTblDonhang);

    Boolean deleteDonHang(String id);

    @Transactional
    tblDonhang themDonHangWithGioHang(tblDonhang newDonhang) throws RuntimeException;

    List<tblChitietdonhang> findChitietdonhangByIddonhang(String idDonhang);


    List<dtoChiTietDonHang> findAllTrangthaiDaNhan();
    List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDaNhan();


    List<dtoChiTietDonHang> findAllTrangthaiChoXacNhan();
    List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiChoXacNhan();

    List<dtoChiTietDonHang> findAllTrangthaiDangGiao();
    List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDangGiao();


    List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDaXacNhan();

    List<dtoChiTietDonHang>findAllTrangthaiHuydonhang();
    List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiHuydonhang();

    dtoChiTietDonHang2 finDonhang(String id);

    dtoChiTietDonHang2 finDonhangAdmin(String id);

    List<dtoChiTietDonHang> findAllDonHangByNguoidung();
    List<dtoChiTietDonHang> findAllDonHang();

    boolean nhanGiaoDonhang(String id);


    boolean duyetDonhang(String id);

    boolean huyDonhang(String id);


    boolean daNhanDonhang(String id);

    Boolean mualaidonhang(String idDonhang);


    List<dtoChiTietDonHang> findAllTrangthaiChoNhanGiao();


}
