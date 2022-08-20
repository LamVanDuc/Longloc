package com.example.projectsem2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "donhang", schema = "dbo", catalog = "clothes")
public class tblDonhang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_donhang")
    private String idDonhang;
    @Basic
    @Column(name = "id_nguoidung")
    private Long idNguoidung;
    @Basic
    @Column(name = "id_diachigiaohang")
    private Long idDiachigiaohang;
    @Basic
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Basic
    @Column(name = "trang_thai")
    private String trangThai;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;
    @Basic
    @Column(name = "ngay_du_kien_giao_hang")
    private Date ngayDuKienGiaoHang;

    public String getIdDonhang() {
        return idDonhang;
    }

    public void setIdDonhang(String idDonhang) {
        this.idDonhang = idDonhang;
    }

    public Long getIdNguoidung() {
        return idNguoidung;
    }

    public void setIdNguoidung(Long idNguoidung) {
        this.idNguoidung = idNguoidung;
    }

    public Long getIdDiachigiaohang() {
        return idDiachigiaohang;
    }

    public void setIdDiachigiaohang(Long idDiachigiaohang) {
        this.idDiachigiaohang = idDiachigiaohang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
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

    public Date getNgayDuKienGiaoHang() {
        return ngayDuKienGiaoHang;
    }

    public void setNgayDuKienGiaoHang(Date ngayDuKienGiaoHang) {
        this.ngayDuKienGiaoHang = ngayDuKienGiaoHang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tblDonhang that = (tblDonhang) o;
        return Objects.equals(idDonhang, that.idDonhang) && Objects.equals(idNguoidung, that.idNguoidung) && Objects.equals(idDiachigiaohang, that.idDiachigiaohang) && Objects.equals(ghiChu, that.ghiChu) && Objects.equals(trangThai, that.trangThai) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua) && Objects.equals(ngayDuKienGiaoHang, that.ngayDuKienGiaoHang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDonhang, idNguoidung, idDiachigiaohang, ghiChu, trangThai, ngayTao, ngayChinhSua, ngayDuKienGiaoHang);
    }
}
