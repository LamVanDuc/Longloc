package com.example.projectsem2.Service;

import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.entity.tblNguoidung;
import com.example.projectsem2.reponsitory.NguoidungReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NguoiDungDetailServiceImpl implements UserDetailsService {
    @Autowired
    NguoidungReponsitory nguoidungReponsitory;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        tblNguoidung nguoidung =  nguoidungReponsitory.findAllByEmailAndTrangThai(email , GenaricClass.ACTIVE).orElseThrow(()->new UsernameNotFoundException("Email Không tồn tại , vui lòng đăng ký !"));
        return NguoiDungDetailImpl.build(nguoidung);
    }

    public Boolean checkEmailExist(String email){
        return nguoidungReponsitory.existsByEmailAndTrangThai(email,GenaricClass.ACTIVE);
    }


    public tblNguoidung saveNguoidung(tblNguoidung nguoidung){
        return nguoidungReponsitory.save(nguoidung);
    }
    public List<tblNguoidung> getAll(){
        return nguoidungReponsitory.findAll();
    }
}
