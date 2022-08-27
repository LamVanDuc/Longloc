package com.example.projectsem2.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "chitietdonhang", schema = "dbo", catalog = "clothes")
@AllArgsConstructor
@NoArgsConstructor
public class tblChitietdonhang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_chitietdonhang")
    private long idChitietdonhang;
    @Basic
    @Column(name = "id_donhang")
    private String idDonhang;
    @Basic
    @Column(name = "so_luong")
    private Long soLuong;
    @Basic
    @Column(name = "gia")
    private Double gia;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;
    @Basic
    @Column(name = "id_sanpham")
    private Long idSanpham;


    public tblChitietdonhang( String idDonhang, Long idSanpham, Long soLuong, Double gia, Date ngayTao) {
        this.idDonhang = idDonhang;
        this.idSanpham = idSanpham;
        this.soLuong = soLuong;
        this.gia = gia;
        this.ngayTao = ngayTao;
    }

    public long getIdChitietdonhang() {
        return idChitietdonhang;
    }

    public void setIdChitietdonhang(long idChitietdonhang) {
        this.idChitietdonhang = idChitietdonhang;
    }

    public String getIdDonhang() {
        return idDonhang;
    }

    public void setIdDonhang(String idDonhang) {
        this.idDonhang = idDonhang;
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
        tblChitietdonhang that = (tblChitietdonhang) o;
        return idChitietdonhang == that.idChitietdonhang && Objects.equals(idDonhang, that.idDonhang) && Objects.equals(idSanpham, that.idSanpham) && Objects.equals(soLuong, that.soLuong) && Objects.equals(gia, that.gia) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChitietdonhang, idDonhang, idSanpham, soLuong, gia, ngayTao, ngayChinhSua);
    }

    public Long getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(Long idSanpham) {
        this.idSanpham = idSanpham;
    }
}
