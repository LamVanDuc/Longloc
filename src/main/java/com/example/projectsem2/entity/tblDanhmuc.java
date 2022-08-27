package com.example.projectsem2.entity;

import javax.persistence.*;
import java.util.Date;

import java.util.Objects;

@Entity
@Table(name = "danhmuc", schema = "dbo", catalog = "clothes")
public class tblDanhmuc {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_danhmuc")
    private long idDanhmuc;
    @Basic
    @Column(name = "id_danhmuc_cha")
    private Long idDanhmucCha;
    @Basic
    @Column(name = "ten_danh_muc")
    private String tenDanhMuc;
    @Basic
    @Column(name = "mo_ta")
    private String moTa;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;

    public long getIdDanhmuc() {
        return idDanhmuc;
    }

    public void setIdDanhmuc(long idDanhmuc) {
        this.idDanhmuc = idDanhmuc;
    }

    public Long getIdDanhmucCha() {
        return idDanhmucCha;
    }

    public void setIdDanhmucCha(Long idDanhmucCha) {
        this.idDanhmucCha = idDanhmucCha;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayChinhSua() {
        return ngayChinhSua;
    }

    public void setNgayChinhSua(Date ngayChinhSua) {
        this.ngayChinhSua = ngayChinhSua;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tblDanhmuc that = (tblDanhmuc) o;
        return idDanhmuc == that.idDanhmuc && Objects.equals(idDanhmucCha, that.idDanhmucCha) && Objects.equals(tenDanhMuc, that.tenDanhMuc) && Objects.equals(moTa, that.moTa) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDanhmuc, idDanhmucCha, tenDanhMuc, moTa, ngayTao, ngayChinhSua);
    }

}
