package com.example.projectsem2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "nhacungcap", schema = "dbo", catalog = "clothes")
public class tblNhacungcap {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_nhacungcap")
    private long idNhacungcap;
    @Basic
    @Column(name = "ten_nhacungcap")
    private String tenNhacungcap;
    @Basic
    @Column(name = "dia_chi")
    private String diaChi;
    @Basic
    @Column(name = "dien_thoai")
    private String dienThoai;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;

    public long getIdNhacungcap() {
        return idNhacungcap;
    }

    public void setIdNhacungcap(long idNhacungcap) {
        this.idNhacungcap = idNhacungcap;
    }

    public String getTenNhacungcap() {
        return tenNhacungcap;
    }

    public void setTenNhacungcap(String tenNhacungcap) {
        this.tenNhacungcap = tenNhacungcap;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
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
        tblNhacungcap that = (tblNhacungcap) o;
        return idNhacungcap == that.idNhacungcap && Objects.equals(tenNhacungcap, that.tenNhacungcap) && Objects.equals(diaChi, that.diaChi) && Objects.equals(dienThoai, that.dienThoai) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNhacungcap, tenNhacungcap, diaChi, dienThoai, ngayTao, ngayChinhSua);
    }
}
