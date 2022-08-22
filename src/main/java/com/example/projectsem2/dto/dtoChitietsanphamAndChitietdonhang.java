package com.example.projectsem2.dto;

import com.example.projectsem2.entity.tblChitietdonhang;
import com.example.projectsem2.entity.tblChitietsanpham;

import java.util.List;

public class dtoChitietsanphamAndChitietdonhang{
    private tblChitietdonhang chitietdonhang;
    private tblChitietsanpham chitietsanpham;

    public dtoChitietsanphamAndChitietdonhang(tblChitietdonhang chitietdonhang, tblChitietsanpham chitietsanpham) {
        this.chitietdonhang = chitietdonhang;
        this.chitietsanpham = chitietsanpham;
    }

    public tblChitietdonhang getChitietdonhang() {
        return chitietdonhang;
    }

    public void setChitietdonhang(tblChitietdonhang chitietdonhang) {
        this.chitietdonhang = chitietdonhang;
    }

    public tblChitietsanpham getChitietsanpham() {
        return chitietsanpham;
    }

    public void setChitietsanpham(tblChitietsanpham chitietsanpham) {
        this.chitietsanpham = chitietsanpham;
    }
}
