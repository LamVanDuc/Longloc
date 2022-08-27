package com.example.projectsem2.dto;

import com.example.projectsem2.entity.tblGiohang;
import com.example.projectsem2.entity.tblSanpham;

public class dtoGioHangAndChiTietSanPham {
    private tblGiohang giohang;
    private tblSanpham sanpham;

    public dtoGioHangAndChiTietSanPham(tblGiohang giohang, tblSanpham sanpham) {
        this.giohang = giohang;
        this.sanpham = sanpham;
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

}
