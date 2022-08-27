package com.example.projectsem2.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "role_nguoidung", schema = "dbo", catalog = "clothes")
public class tblRoleNguoidung {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_role_nguoidung")
    private long idRoleNguoidung;
    @Basic
    @Column(name = "id_nguoidung")
    private Long idNguoidung;
    @Basic
    @Column(name = "id_role")
    private Long idRole;
    @Basic
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Basic
    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;

    public long getIdRoleNguoidung() {
        return idRoleNguoidung;
    }

    public void setIdRoleNguoidung(long idRoleNguoidung) {
        this.idRoleNguoidung = idRoleNguoidung;
    }

    public Long getIdNguoidung() {
        return idNguoidung;
    }

    public void setIdNguoidung(Long idNguoidung) {
        this.idNguoidung = idNguoidung;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
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
        tblRoleNguoidung that = (tblRoleNguoidung) o;
        return idRoleNguoidung == that.idRoleNguoidung && Objects.equals(idNguoidung, that.idNguoidung) && Objects.equals(idRole, that.idRole) && Objects.equals(ngayTao, that.ngayTao) && Objects.equals(ngayChinhSua, that.ngayChinhSua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoleNguoidung, idNguoidung, idRole, ngayTao, ngayChinhSua);
    }


}
