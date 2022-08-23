package com.example.projectsem2.dto;

import com.example.projectsem2.entity.tblDonhang;

import java.util.List;


public class dtoChiTietDonHang {
    private tblDonhang donhang;
    private List<dtoChitietsanphamAndChitietdonhang> chitietsanphamAndChitietdonhang;

    public dtoChiTietDonHang() {}

    public dtoChiTietDonHang(tblDonhang donhang, List<dtoChitietsanphamAndChitietdonhang> chitietsanphamAndChitietdonhang) {
        this.donhang = donhang;
        this.chitietsanphamAndChitietdonhang = chitietsanphamAndChitietdonhang;
    }

    public tblDonhang getDonhang() {
        return donhang;
    }

    public void setDonhang(tblDonhang donhang) {
        this.donhang = donhang;
    }

    public List<dtoChitietsanphamAndChitietdonhang> getChitietsanphamAndChitietdonhang() {
        return chitietsanphamAndChitietdonhang;
    }

    public void setChitietsanphamAndChitietdonhang(List<dtoChitietsanphamAndChitietdonhang> chitietsanphamAndChitietdonhang) {
        this.chitietsanphamAndChitietdonhang = chitietsanphamAndChitietdonhang;
    }
}
