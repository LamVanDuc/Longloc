package com.example.projectsem2.dto.donhang;


import com.example.projectsem2.entity.tblDonhang;
import java.util.List;
public class dtoDonhangAndChitietdonhang {
    tblDonhang donhang;
    List<dtoChiTietDonHang> chitietdonhang;

    public dtoDonhangAndChitietdonhang(tblDonhang donhang, List<dtoChiTietDonHang> chitietdonhang) {
        this.donhang = donhang;
        this.chitietdonhang = chitietdonhang;
    }

    public tblDonhang getDonhang() {
        return donhang;
    }

    public void setDonhang(tblDonhang donhang) {
        this.donhang = donhang;
    }

    public List<dtoChiTietDonHang> getChitietdonhang() {
        return chitietdonhang;
    }

    public void setChitietdonhang(List<dtoChiTietDonHang> chitietdonhang) {
        this.chitietdonhang = chitietdonhang;
    }
}
