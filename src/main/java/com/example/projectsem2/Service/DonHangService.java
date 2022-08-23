package com.example.projectsem2.Service;

import com.example.projectsem2.dto.dtoChiTietDonHang;
import com.example.projectsem2.entity.tblChitietdonhang;
import com.example.projectsem2.entity.tblDonhang;
import javassist.NotFoundException;

import java.util.List;

import java.util.Optional;

public interface DonHangService {

    dtoChiTietDonHang getByIdDonHang(String id) throws NotFoundException;

    tblDonhang findDonhangByIdDonHang(String id);

    List<tblDonhang> getAll();

    tblDonhang updateDonHang(String id, tblDonhang newTblDonhang);

    Boolean deleteDonHang(String id);

    tblDonhang themDonHangWithGioHang(tblDonhang newDonhang) throws RuntimeException;

    List<tblChitietdonhang> findByChitietDonhang(Long idChitietdonhang);


    List<dtoChiTietDonHang> findAllTrangthaiDaNhan();
    List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDaNhan();


    List<dtoChiTietDonHang> findAllTrangthaiChoXacNhan();
    List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiChoXacNhan();

    List<dtoChiTietDonHang> findAllTrangthaiDangGiao();
    List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiDangGiao();

    List<dtoChiTietDonHang>findAllTrangthaiHuydonhang();
    List<dtoChiTietDonHang> findDonhangByIdNguoiDungAndTrangthaiHuydonhang();


    List<dtoChiTietDonHang> findAllDonHangUser();
    List<dtoChiTietDonHang> findAllDonHang();

    boolean daNhanHang(String id);


    boolean duyetDonhang(String id);

    boolean huyDonhang(String id);


    boolean daNhanDonhang(String id);


}
