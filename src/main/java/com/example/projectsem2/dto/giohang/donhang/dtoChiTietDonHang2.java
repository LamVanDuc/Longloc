package com.example.projectsem2.dto.giohang.donhang;

import com.example.projectsem2.dto.dtoSanphamAndChitietdonhang;
import com.example.projectsem2.entity.tblDiachigiaohang;
import com.example.projectsem2.entity.tblDonhang;

import java.util.List;
import java.util.Optional;

public class dtoChiTietDonHang2 {

    private tblDonhang donhang;
    private List<dtoSanphamAndChitietdonhang> chitietsanphamAndChitietdonhang;
    private Optional<tblDiachigiaohang> diachigiaohang;


    public dtoChiTietDonHang2(tblDonhang donhang, List<dtoSanphamAndChitietdonhang> chitietsanphamAndChitietdonhang, Optional<tblDiachigiaohang> diachigiaohang) {
        this.donhang = donhang;
        this.chitietsanphamAndChitietdonhang = chitietsanphamAndChitietdonhang;
        this.diachigiaohang = diachigiaohang;

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

    public Optional<tblDiachigiaohang> getDiachigiaohang() {
        return diachigiaohang;
    }

    public void setDiachigiaohang(Optional<tblDiachigiaohang> diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }
}
