package com.example.projectsem2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "giohang", schema = "dbo", catalog = "clothes")
public class tblGiohang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_giohang")
    private long idGiohang;
    @Basic
    @Column(name = "id_nguoidung")
    private Long idNguoidung;
    @Basic
    @Column(name = "so_luong")
    private Long soLuong;
    @Basic
    @Column(name = "gia")
    private Double gia;
    @Basic
    @Column(name = "id_sanpham")
    private Long idSanpham;

    public tblGiohang(Long idSanpham, Long soLuong) {
        this.idSanpham = idSanpham;
        this.soLuong = soLuong;
    }

    public tblGiohang() {
    }

    public long getIdGiohang() {
        return idGiohang;
    }

    public void setIdGiohang(long idGiohang) {
        this.idGiohang = idGiohang;
    }

    public Long getIdNguoidung() {
        return idNguoidung;
    }

    public void setIdNguoidung(Long idNguoidung) {
        this.idNguoidung = idNguoidung;
    }


    public Long getSoLuong() {
        return soLuong;
    }


    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGia() {
        return gia;
    }


    public void setGia(Double gia) {
        this.gia = gia;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tblGiohang that = (tblGiohang) o;
        return idGiohang == that.idGiohang && Objects.equals(idNguoidung, that.idNguoidung) && Objects.equals(soLuong, that.soLuong) && Objects.equals(gia, that.gia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGiohang, idNguoidung, soLuong, gia);
    }

    public Long getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(Long idSanpham) {
        this.idSanpham = idSanpham;
    }
}
