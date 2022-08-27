package com.example.projectsem2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "nguoidung", schema = "dbo", catalog = "clothes")
public class tblNguoidung {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_nguoidung")
    private long idNguoidung;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "dien_thoai")
    private String dienThoai;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "trang_thai")
    private String trangThai;
    @Basic
    @Column(name = "loai_tai_khoan")
    private String loaiTaiKhoan;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;


    public long getIdNguoidung() {
        return idNguoidung;
    }

    public void setIdNguoidung(long idNguoidung) {
        this.idNguoidung = idNguoidung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getLoaiTaiKhoan() {
        return loaiTaiKhoan;
    }

    public void setLoaiTaiKhoan(String loaiTaiKhoan) {
        this.loaiTaiKhoan = loaiTaiKhoan;
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
        tblNguoidung that = (tblNguoidung) o;
        return idNguoidung == that.idNguoidung && Objects.equals(email, that.email) && Objects.equals(dienThoai, that.dienThoai) && Objects.equals(password, that.password) && Objects.equals(trangThai, that.trangThai) && Objects.equals(loaiTaiKhoan, that.loaiTaiKhoan) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNguoidung, email, dienThoai, password, trangThai, loaiTaiKhoan, ngayTao, ngayChinhSua);
    }


}
