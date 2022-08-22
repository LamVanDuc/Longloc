package com.example.projectsem2.dto;

import com.example.projectsem2.entity.tblChitietsanpham;
import com.example.projectsem2.entity.tblSanpham;
import java.util.List;

public class dtoChitietSanphamAndSanPham {
    private tblSanpham sanpham;
    private List<tblChitietsanpham> chitietsanphams;

    public dtoChitietSanphamAndSanPham(tblSanpham sanpham, List<tblChitietsanpham> chitietsanphams) {
        this.sanpham = sanpham;
        this.chitietsanphams = chitietsanphams;
    }

    public tblSanpham getSanpham() {
        return sanpham;
    }

    public void setSanpham(tblSanpham sanpham) {
        this.sanpham = sanpham;
    }

    public List<tblChitietsanpham> getChitietsanphams() {
        return chitietsanphams;
    }

    public void setChitietsanphams(List<tblChitietsanpham> chitietsanphams) {
        this.chitietsanphams = chitietsanphams;
    }
}
