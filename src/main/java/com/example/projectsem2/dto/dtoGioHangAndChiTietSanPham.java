package com.example.projectsem2.dto;

import com.example.projectsem2.entity.tblChitietsanpham;
import com.example.projectsem2.entity.tblGiohang;
import com.example.projectsem2.entity.tblSanpham;

public class dtoGioHangAndChiTietSanPham {
    private tblGiohang giohang;
    private tblSanpham sanpham;
    private tblChitietsanpham chitietsanpham;

    public dtoGioHangAndChiTietSanPham(tblGiohang giohang, tblSanpham sanpham, tblChitietsanpham chitietsanpham) {
        this.giohang = giohang;
        this.sanpham = sanpham;
        this.chitietsanpham = chitietsanpham;
    }

    public tblGiohang getGiohang() {
        return giohang;
    }

    public void setGiohang(tblGiohang giohang) {
        this.giohang = giohang;
    }

    public tblSanpham getSanpham() {
        return sanpham;
    }

    public void setSanpham(tblSanpham sanpham) {
        this.sanpham = sanpham;
    }

    public tblChitietsanpham getChitietsanpham() {
        return chitietsanpham;
    }

    public void setChitietsanpham(tblChitietsanpham chitietsanpham) {
        this.chitietsanpham = chitietsanpham;
    }
}
