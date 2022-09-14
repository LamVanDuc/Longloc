package com.example.projectsem2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "image", schema = "dbo", catalog = "clothes")
public class tblImage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_image")
    private long idImage;
    @Basic
    @Column(name = "ten_anh")
    private String tenAnh;
    @Basic
    @Column(name = "id_sanpham")
    private Long idSanpham;

    public tblImage( String tenAnh, Long idSanpham) {
        this.tenAnh = tenAnh;
        this.idSanpham = idSanpham;
    }

    public tblImage() {

    }

    public long getIdImage() {
        return idImage;
    }

    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }


    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        tblImage tblImage = (tblImage) o;
        return idImage == tblImage.idImage  && Objects.equals(tenAnh, tblImage.tenAnh);
    }

    public Long getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(Long idSanpham) {
        this.idSanpham = idSanpham;
    }
}
