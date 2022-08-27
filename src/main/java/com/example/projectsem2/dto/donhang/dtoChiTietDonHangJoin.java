package com.example.projectsem2.dto.donhang;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.sql.Date;

public class dtoChiTietDonHangJoin {

    private long idChitietdonhang;

    private String idDonhang;

    private Long idChitietsanpham;

    private Long soLuong;

    private Double gia;

    private long idSanpham;

    private String img;

    private String tenSanPham;

    private String moTa;

    private String thuongHieu;

    private String phanLoai;

    private String mauSac;

    private String kichCo;

    private String chatLieu;

    public dtoChiTietDonHangJoin(long idChitietdonhang, String idDonhang, Long idChitietsanpham, Long soLuong, Double gia, long idSanpham, String img, String tenSanPham, String moTa, String thuongHieu, String phanLoai, String mauSac, String kichCo, String chatLieu) {
        this.idChitietdonhang = idChitietdonhang;
        this.idDonhang = idDonhang;
        this.idChitietsanpham = idChitietsanpham;
        this.soLuong = soLuong;
        this.gia = gia;
        this.idSanpham = idSanpham;
        this.img = img;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.thuongHieu = thuongHieu;
        this.phanLoai = phanLoai;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
        this.chatLieu = chatLieu;
    }

    public long getIdChitietdonhang() {
        return idChitietdonhang;
    }

    public void setIdChitietdonhang(long idChitietdonhang) {
        this.idChitietdonhang = idChitietdonhang;
    }

    public String getIdDonhang() {
        return idDonhang;
    }

    public void setIdDonhang(String idDonhang) {
        this.idDonhang = idDonhang;
    }

    public Long getIdChitietsanpham() {
        return idChitietsanpham;
    }

    public void setIdChitietsanpham(Long idChitietsanpham) {
        this.idChitietsanpham = idChitietsanpham;
    }

    public Long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public long getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(long idSanpham) {
        this.idSanpham = idSanpham;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }
}
