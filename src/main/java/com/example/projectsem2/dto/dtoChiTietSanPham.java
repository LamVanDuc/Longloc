package com.example.projectsem2.dto;

import javax.persistence.Basic;
import javax.persistence.Column;

public class dtoChiTietSanPham {
    private long idSanpham;

    private Long idNhacungcap;

    private Long idDanhmuc;

    private String img;

    private String tenSanPham;

    private String moTa;

    private String thuongHieu;

    private long idChitietsanpham;

    private String phanLoai;

    private String mauSac;

    private String kichCo;

    private String chatLieu;

    private Integer soLuong;

    private Integer giaBan;


    public dtoChiTietSanPham(long idSanpham, Long idNhacungcap, Long idDanhmuc, String img, String tenSanPham, String moTa, String thuongHieu, long idChitietsanpham, String phanLoai, String mauSac, String kichCo, String chatLieu, Integer soLuong, Integer giaBan) {
        this.idSanpham = idSanpham;
        this.idNhacungcap = idNhacungcap;
        this.idDanhmuc = idDanhmuc;
        this.img = img;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.thuongHieu = thuongHieu;
        this.idChitietsanpham = idChitietsanpham;
        this.phanLoai = phanLoai;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
        this.chatLieu = chatLieu;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public long getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(long idSanpham) {
        this.idSanpham = idSanpham;
    }

    public Long getIdNhacungcap() {
        return idNhacungcap;
    }

    public void setIdNhacungcap(Long idNhacungcap) {
        this.idNhacungcap = idNhacungcap;
    }

    public Long getIdDanhmuc() {
        return idDanhmuc;
    }

    public void setIdDanhmuc(Long idDanhmuc) {
        this.idDanhmuc = idDanhmuc;
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

    public long getIdChitietsanpham() {
        return idChitietsanpham;
    }

    public void setIdChitietsanpham(long idChitietsanpham) {
        this.idChitietsanpham = idChitietsanpham;
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

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }


}
