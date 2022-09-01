package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.entity.tblNguoidung;
import com.example.projectsem2.reponsitory.NguoidungReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoiDungServiceImpl implements NguoiDungService{

    @Autowired
    NguoidungReponsitory nguoidungReponsitory;

    public static String getLoginEmail(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    @Override
    public List<tblNguoidung> getAll() {
        return nguoidungReponsitory.findAll();
    }

    @Override
    public Long idNguoidung() {
            Optional<tblNguoidung> nguoidung = findByEmail();
            if (nguoidung.isEmpty()){
                throw new RuntimeException("Không tìm thấy người dùng");
            }else {
                Long id = nguoidung.get().getIdNguoidung();
                return id;
            }
        }

    @Override
    public Optional<tblNguoidung> findByEmail() {
        Optional<tblNguoidung> nguoidung = nguoidungReponsitory.findByEmail(getLoginEmail());
        return nguoidung;
    }

    @Override
    public tblNguoidung update(String email, tblNguoidung newNguoidung) {
        tblNguoidung nguoidung = nguoidungReponsitory.findByEmail(email).map(nd->{
            nd.setPassword(newNguoidung.getPassword());
            nd.setDienThoai(newNguoidung.getDienThoai());
            return nguoidungReponsitory.save(nd);
        }).orElseThrow(()->new RuntimeException("Không tồn tại tài khoản !"));
        return nguoidung;
    }

    @Override
    public tblNguoidung delete(String email) {
        tblNguoidung nguoidung = nguoidungReponsitory.findByEmail(email).map(nd->{
            nd.setTrangThai(GenaricClass.IN_ACTIVE);
            return nguoidungReponsitory.save(nd);
        }).orElseThrow(()->new RuntimeException("Không tồn tại tài khoản !"));
        return nguoidung;
    }
}
