package com.example.projectsem2.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "chitietsanpham", schema = "dbo", catalog = "clothes")
@AllArgsConstructor
@NoArgsConstructor
public class tblChitietsanpham {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_chitietsanpham")
    private long idChitietsanpham;
    @Basic
    @Column(name = "id_sanpham")
    private Long idSanpham;
    @Basic
    @Column(name = "phan_loai")
    private String phanLoai;
    @Basic
    @Column(name = "mau_sac")
    private String mauSac;
    @Basic
    @Column(name = "kich_co")
    private String kichCo;
    @Basic
    @Column(name = "chat_lieu")
    private String chatLieu;
    @Basic
    @Column(name = "so_luong")
    private Integer soLuong;
    @Basic
    @Column(name = "gia_ban")
    private Integer giaBan;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;

    public long getIdChitietsanpham() {
        return idChitietsanpham;
    }

    public void setIdChitietsanpham(long idChitietsanpham) {
        this.idChitietsanpham = idChitietsanpham;
    }

    public Long getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(Long idSanpham) {
        this.idSanpham = idSanpham;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
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
        tblChitietsanpham that = (tblChitietsanpham) o;
        return idChitietsanpham == that.idChitietsanpham && Objects.equals(idSanpham, that.idSanpham) && Objects.equals(phanLoai, that.phanLoai) && Objects.equals(mauSac, that.mauSac) && Objects.equals(kichCo, that.kichCo) && Objects.equals(chatLieu, that.chatLieu) && Objects.equals(soLuong, that.soLuong) && Objects.equals(giaBan, that.giaBan) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChitietsanpham, idSanpham, phanLoai, mauSac, kichCo, chatLieu, soLuong, giaBan, ngayTao, ngayChinhSua);
    }
}
