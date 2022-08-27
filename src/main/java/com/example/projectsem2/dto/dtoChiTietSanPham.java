package com.example.projectsem2.dto;

import com.example.projectsem2.entity.tblImage;
import com.example.projectsem2.entity.tblSanpham;
import java.util.List;

public class dtoChiTietSanPham {
    tblSanpham sanpham;
    List<tblSanpham> chitietsanphamList;
    List<tblImage> images;
    List<String> size;
    List<String> color;

    public dtoChiTietSanPham(tblSanpham sanpham, List<tblSanpham> chitietsanphamList, List<tblImage> images, List<String> size, List<String> color) {
        this.sanpham = sanpham;
        this.chitietsanphamList = chitietsanphamList;
        this.images = images;
        this.size = size;
        this.color = color;
    }

    public dtoChiTietSanPham(tblSanpham sanpham, List<tblSanpham> chitietsanphamList , List<tblImage> images) {
        this.sanpham = sanpham;
        this.chitietsanphamList = chitietsanphamList;
        this.images = images;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public List<tblImage> getImages() {
        return images;
    }

    public void setImages(List<tblImage> images) {
        this.images = images;
    }

    public tblSanpham getSanpham() {
        return sanpham;
    }

    public void setSanpham(tblSanpham sanpham) {
        this.sanpham = sanpham;
    }

    public List<tblSanpham> getChitietsanphamList() {
        return chitietsanphamList;
    }

    public void setChitietsanphamList(List<tblSanpham> chitietsanphamList) {
        this.chitietsanphamList = chitietsanphamList;
    }


}
