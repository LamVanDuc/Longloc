package com.example.projectsem2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sanpham", schema = "dbo", catalog = "clothes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class tblSanpham {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_sanpham")
    private long idSanpham;
    @Basic
    @Column(name = "id_sanpham_cha")
    private Long idSanphamCha;
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
    @Column(name = "gia_ban")
    private Double giaBan;
    @Basic
    @Column(name = "chat_lieu")
    private String chatLieu;
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
    @Column(name = "so_luong")
    private Long soLuong;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;

    public tblSanpham( Long idSanphamCha,
                       Long idDanhmuc,
                       String tenSanPham,
                       Long idNhacungcap,
                       String moTa,
                       String thuongHieu,
                       Double giaBan,
                       String chatLieu,
                       String phanLoai,
                       String mauSac,
                       String kichCo,
                       Long soLuong,
                       String img
                       ) {


        this.idSanphamCha = idSanphamCha;
        this.idNhacungcap = idNhacungcap;
        this.idDanhmuc = idDanhmuc;
        this.img = img;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.thuongHieu = thuongHieu;
        this.giaBan = giaBan;
        this.chatLieu = chatLieu;
        this.phanLoai = phanLoai;
        this.mauSac = mauSac;
        this.kichCo = kichCo;
        this.soLuong = soLuong;

    }

    public tblSanpham(String tenSanpham, String moTa, String thuongHieu, Double giaBan, String chatLieu, String phanLoai, String fileDownloadUri) {


        this.img = fileDownloadUri;
        this.tenSanPham = tenSanpham;
        this.moTa = moTa;
        this.thuongHieu = thuongHieu;
        this.giaBan = giaBan;
        this.chatLieu = chatLieu;
        this.phanLoai = phanLoai;

    }

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

    public Double getGiaBan() {
        return giaBan;
    }


    public void setGiaBan(Double giaBan) {
        this.giaBan = giaBan;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
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

    public Long getIdSanphamCha() {
        return idSanphamCha;
    }

    public void setIdSanphamCha(Long idSanphamCha) {
        this.idSanphamCha = idSanphamCha;
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

    public Long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }

}
