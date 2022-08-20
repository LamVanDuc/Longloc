package com.example.projectsem2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "diachigiaohang", schema = "dbo", catalog = "clothes")
public class tblDiachigiaohang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_diachigiaohang")
    private long idDiachigiaohang;
    @Basic
    @Column(name = "id_nguoidung")
    private Long idNguoidung;
    @Basic
    @Column(name = "ten_nguoi_nhan")
    private String tenNguoiNhan;
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

    public long getIdDiachigiaohang() {
        return idDiachigiaohang;
    }

    public void setIdDiachigiaohang(long idDiachigiaohang) {
        this.idDiachigiaohang = idDiachigiaohang;
    }

    public Long getIdNguoidung() {
        return idNguoidung;
    }

    public void setIdNguoidung(Long idNguoidung) {
        this.idNguoidung = idNguoidung;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
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
        tblDiachigiaohang that = (tblDiachigiaohang) o;
        return idDiachigiaohang == that.idDiachigiaohang && Objects.equals(idNguoidung, that.idNguoidung) && Objects.equals(tenNguoiNhan, that.tenNguoiNhan) && Objects.equals(diaChi, that.diaChi) && Objects.equals(dienThoai, that.dienThoai) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiachigiaohang, idNguoidung, tenNguoiNhan, diaChi, dienThoai, ngayTao, ngayChinhSua);
    }
}
