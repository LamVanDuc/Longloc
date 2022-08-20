package com.example.projectsem2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "sanpham", schema = "dbo", catalog = "clothes")
public class tblSanpham {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_sanpham")
    private long idSanpham;
    @Basic
    @Column(name = "id_nhacungcap")
    private Long idNhacungcap;
    @Basic
    @Column(name = "id_danhmuc")
    private Long idDanhmuc;
    @Basic
    @Column(name = "img")
    private String img;
    @Basic
    @Column(name = "ten_san_pham")
    private String tenSanPham;
    @Basic
    @Column(name = "mo_ta")
    private String moTa;
    @Basic
    @Column(name = "thuong_hieu")
    private String thuongHieu;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;

    public long getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(long idSanpham) {
        this.idSanpham = idSanpham;
    }

    public Long getIdNhacungcap() {
        return idNhacungcap;
    }

    public void setIdNhacungcap(Long idNhacungcap) {
        this.idNhacungcap = idNhacungcap;
    }

    public Long getIdDanhmuc() {
        return idDanhmuc;
    }

    public void setIdDanhmuc(Long idDanhmuc) {
        this.idDanhmuc = idDanhmuc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
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
        tblSanpham that = (tblSanpham) o;
        return idSanpham == that.idSanpham && Objects.equals(idNhacungcap, that.idNhacungcap) && Objects.equals(idDanhmuc, that.idDanhmuc) && Objects.equals(img, that.img) && Objects.equals(tenSanPham, that.tenSanPham) && Objects.equals(moTa, that.moTa) && Objects.equals(thuongHieu, that.thuongHieu) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSanpham, idNhacungcap, idDanhmuc, img, tenSanPham, moTa, thuongHieu, ngayTao, ngayChinhSua);
    }
}
