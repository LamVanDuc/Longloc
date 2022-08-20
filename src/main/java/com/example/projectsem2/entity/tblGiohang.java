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
    @Column(name = "id_chitietsanpham")
    private Long idChitietsanpham;
    @Basic
    @Column(name = "so_luong")
    private Integer soLuong;
    @Basic
    @Column(name = "gia")
    private Integer gia;
    @Basic
    @Column(name = "chot")
    private String chot;

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

    public Long getIdChitietsanpham() {
        return idChitietsanpham;
    }

    public void setIdChitietsanpham(Long idChitietsanpham) {
        this.idChitietsanpham = idChitietsanpham;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getChot() {
        return chot;
    }

    public void setChot(String chot) {
        this.chot = chot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tblGiohang that = (tblGiohang) o;
        return idGiohang == that.idGiohang && Objects.equals(idNguoidung, that.idNguoidung) && Objects.equals(idChitietsanpham, that.idChitietsanpham) && Objects.equals(soLuong, that.soLuong) && Objects.equals(gia, that.gia) && Objects.equals(chot, that.chot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGiohang, idNguoidung, idChitietsanpham, soLuong, gia, chot);
    }
}
