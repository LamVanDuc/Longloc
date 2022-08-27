package com.example.projectsem2.dto;

import com.example.projectsem2.entity.tblChitietdonhang;
import com.example.projectsem2.entity.tblSanpham;

public class dtoSanphamAndChitietdonhang {
    private tblChitietdonhang chitietdonhang;
    private tblSanpham sanpham;

    public dtoSanphamAndChitietdonhang(tblChitietdonhang chitietdonhang, tblSanpham sanpham) {
        this.chitietdonhang = chitietdonhang;
        this.sanpham = sanpham;
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


}
