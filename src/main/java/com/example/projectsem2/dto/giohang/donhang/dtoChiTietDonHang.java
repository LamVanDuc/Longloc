package com.example.projectsem2.dto.giohang.donhang;

import com.example.projectsem2.dto.dtoSanphamAndChitietdonhang;
import com.example.projectsem2.entity.tblDonhang;

import java.util.List;


public class dtoChiTietDonHang {
    private tblDonhang donhang;
    private List<dtoSanphamAndChitietdonhang> chitietsanphamAndChitietdonhang;

    public dtoChiTietDonHang() {}

    public dtoChiTietDonHang(tblDonhang donhang, List<dtoSanphamAndChitietdonhang> chitietsanphamAndChitietdonhang) {
        this.donhang = donhang;
        this.chitietsanphamAndChitietdonhang = chitietsanphamAndChitietdonhang;
    }

    public tblDonhang getDonhang() {
        return donhang;
    }

    public void setDonhang(tblDonhang donhang) {
        this.donhang = donhang;
    }

    public List<dtoSanphamAndChitietdonhang> getChitietsanphamAndChitietdonhang() {
        return chitietsanphamAndChitietdonhang;
    }

    public void setChitietsanphamAndChitietdonhang(List<dtoSanphamAndChitietdonhang> chitietsanphamAndChitietdonhang) {
        this.chitietsanphamAndChitietdonhang = chitietsanphamAndChitietdonhang;
    }
}
