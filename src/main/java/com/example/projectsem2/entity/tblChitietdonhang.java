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
public class tblChitietdonhang extends tblDonhang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_chitietdonhang")
    private long idChitietdonhang;
    @Basic
    @Column(name = "id_donhang")
    private String idDonhang;
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
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;

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
        return idChitietdonhang == that.idChitietdonhang && Objects.equals(idDonhang, that.idDonhang) && Objects.equals(idChitietsanpham, that.idChitietsanpham) && Objects.equals(soLuong, that.soLuong) && Objects.equals(gia, that.gia) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChitietdonhang, idDonhang, idChitietsanpham, soLuong, gia, ngayTao, ngayChinhSua);
    }
}
