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
    @Column(name = "id_chitietsanpham")
    private Long idChitietsanpham;
    @Basic
    @Column(name = "ten_anh")
    private String tenAnh;

    public long getIdImage() {
        return idImage;
    }

    public void setIdImage(long idImage) {
        this.idImage = idImage;
    }

    public Long getIdChitietsanpham() {
        return idChitietsanpham;
    }

    public void setIdChitietsanpham(Long idChitietsanpham) {
        this.idChitietsanpham = idChitietsanpham;
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
        return idImage == tblImage.idImage && Objects.equals(idChitietsanpham, tblImage.idChitietsanpham) && Objects.equals(tenAnh, tblImage.tenAnh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idImage, idChitietsanpham, tenAnh);
    }
}
