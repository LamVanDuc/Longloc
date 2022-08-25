package com.example.projectsem2.dto;

import com.example.projectsem2.entity.tblChitietsanpham;
import com.example.projectsem2.entity.tblSanpham;
import java.util.List;

public class dtoChiTietSanPham {
    tblSanpham sanpham;
    List<tblChitietsanpham> chitietsanphamList;

    public dtoChiTietSanPham(tblSanpham sanpham, List<tblChitietsanpham> chitietsanphamList) {
        this.sanpham = sanpham;
        this.chitietsanphamList = chitietsanphamList;
    }

    public tblSanpham getSanpham() {
        return sanpham;
    }

    public void setSanpham(tblSanpham sanpham) {
        this.sanpham = sanpham;
    }

    public List<tblChitietsanpham> getChitietsanphamList() {
        return chitietsanphamList;
    }

    public void setChitietsanphamList(List<tblChitietsanpham> chitietsanphamList) {
        this.chitietsanphamList = chitietsanphamList;
    }


}
