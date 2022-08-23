package com.example.projectsem2.dto;

import com.example.projectsem2.entity.tblChitietdonhang;
import com.example.projectsem2.entity.tblChitietsanpham;
import com.example.projectsem2.entity.tblSanpham;

public class dtoChitietsanphamAndChitietdonhang {
    private tblChitietdonhang chitietdonhang;
    private tblSanpham sanpham;
    private tblChitietsanpham chitietsanpham;

    public dtoChitietsanphamAndChitietdonhang(tblChitietdonhang chitietdonhang, tblSanpham sanpham, tblChitietsanpham chitietsanpham) {
        this.chitietdonhang = chitietdonhang;
        this.sanpham = sanpham;
        this.chitietsanpham = chitietsanpham;
    }

    public tblChitietdonhang getChitietdonhang() {
        return chitietdonhang;
    }

    public void setChitietdonhang(tblChitietdonhang chitietdonhang) {
        this.chitietdonhang = chitietdonhang;
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
