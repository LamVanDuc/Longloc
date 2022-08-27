package com.example.projectsem2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "voucher", schema = "dbo", catalog = "clothes")
public class tblVoucher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_voucher")
    private long idVoucher;
    @Basic
    @Column(name = "id_nguoidung")
    private Long idNguoidung;
    @Basic
    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;
    @Basic
    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;
    @Basic
    @Column(name = "dieu_kien")
    private String dieuKien;
    @Basic
    @Column(name = "tri_gia")
    private Double triGia;
    @Basic
    @Column(name = "noi_dung")
    private String noiDung;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;


    public long getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(long idVoucher) {
        this.idVoucher = idVoucher;
    }

    public Long getIdNguoidung() {
        return idNguoidung;
    }

    public void setIdNguoidung(Long idNguoidung) {
        this.idNguoidung = idNguoidung;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    public Double getTriGia() {
        return triGia;
    }

    public void setTriGia(Double triGia) {
        this.triGia = triGia;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
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
        tblVoucher that = (tblVoucher) o;
        return idVoucher == that.idVoucher && Objects.equals(idNguoidung, that.idNguoidung) && Objects.equals(ngayBatDau, that.ngayBatDau) && Objects.equals(ngayKetThuc, that.ngayKetThuc) && Objects.equals(dieuKien, that.dieuKien) && Objects.equals(triGia, that.triGia) && Objects.equals(noiDung, that.noiDung) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVoucher, idNguoidung, ngayBatDau, ngayKetThuc, dieuKien, triGia, noiDung, ngayTao, ngayChinhSua);
    }

}
