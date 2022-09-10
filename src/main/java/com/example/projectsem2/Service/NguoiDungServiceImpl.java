package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.dtoThayDoiNguoiDung;
import com.example.projectsem2.entity.tblNguoidung;
import com.example.projectsem2.reponsitory.NguoidungReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoiDungServiceImpl implements NguoiDungService{

    @Autowired
    NguoidungReponsitory nguoidungReponsitory;

    @Autowired
    PasswordEncoder passwordEncoder;


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
    public tblNguoidung update(dtoThayDoiNguoiDung dtoThayDoiNguoiDung) {


        tblNguoidung nguoidung = nguoidungReponsitory.findByEmail(getLoginEmail()).map(nd->{
            nd.setDienThoai(dtoThayDoiNguoiDung.getPhoneNumber());
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

    @Override
    public tblNguoidung changePassword(dtoThayDoiNguoiDung dtoThayDoiNguoiDung) {
        if(dtoThayDoiNguoiDung.getPassword().length() < 8){
            throw new RuntimeException("Mật khẩu phải lớn hơn ́ ký tự");
        }
        tblNguoidung nguoidung = nguoidungReponsitory.findByEmail(getLoginEmail()).map(nd->{

            Boolean check = passwordEncoder.matches(dtoThayDoiNguoiDung.getPassword(), nd.getPassword());

            if (check){
                String newPassword = passwordEncoder.encode(dtoThayDoiNguoiDung.getNewPassword());
                nd.setPassword(newPassword);
            }else{
                throw new RuntimeException("Mật khẩu chính xác !");
            }

            return nguoidungReponsitory.save(nd);
        }).orElseThrow(()->new RuntimeException("Không tồn tại tài khoản !"));
        return nguoidung;
    }
}
