package com.example.projectsem2.entity;

import javax.persistence.*;
import java.util.Date;

import java.util.Objects;

@Entity
@Table(name = "role", schema = "dbo", catalog = "clothes")
public class tblRole {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_role")
    private long idRole;
    @Basic
    @Column(name = "ten_role")
    private String tenRole;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;


    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getTenRole() {
        return tenRole;
    }

    public void setTenRole(String tenRole) {
        this.tenRole = tenRole;
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
        tblRole tblRole = (tblRole) o;
        return idRole == tblRole.idRole && Objects.equals(tenRole, tblRole.tenRole) && Objects.equals(ngayTao, tblRole.ngayTao) && Objects.equals(ngayChinhSua, tblRole.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, tenRole, ngayTao, ngayChinhSua);
    }

}
