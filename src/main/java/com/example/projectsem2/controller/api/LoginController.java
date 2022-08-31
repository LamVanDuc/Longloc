package com.example.projectsem2.controller.api;

import com.example.projectsem2.Service.NguoiDungDetailServiceImpl;
import com.example.projectsem2.Service.RoleService;
import com.example.projectsem2.comman.GenaricClass;
import com.example.projectsem2.dto.login.RegisterAccount;
import com.example.projectsem2.dto.responseObject;
import com.example.projectsem2.entity.tblNguoidung;
import com.example.projectsem2.entity.tblRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class LoginController {

    @Autowired
    NguoiDungDetailServiceImpl nguoiDungDetailService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<responseObject> saveUser(@RequestBody RegisterAccount registerAccount){
        try{
            if (nguoiDungDetailService.checkEmailExist(registerAccount.getEmail())){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new responseObject("false","tài khoản đã tồn tại",""));
            }else{
                tblNguoidung nguoidung = new tblNguoidung();
                nguoidung.setEmail(registerAccount.getEmail());
                String password = passwordEncoder.encode(registerAccount.getPassword());
                nguoidung.setPassword(password);
                nguoidung.setDienThoai(registerAccount.getPhoneNumber());

                Set<tblRole> roles = new HashSet<tblRole>();

                tblRole role = roleService.findByTenRole(GenaricClass.ROLE_USER);
                roles.add(role);
                nguoidung.setRole(roles);
                nguoidung.setNgayTao(GenaricClass.dateTimeNow());
                nguoidung.setTrangThai(GenaricClass.ACTIVE);

                Object check = nguoiDungDetailService.saveNguoidung(nguoidung);
                return ResponseEntity.status(HttpStatus.OK).body(new responseObject("ok" ," Tạo tài khoản thành công !",check));
            }
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("ok" ," Tạo tài khoản Không thành công ",ex.getLocalizedMessage()));
        }
    }

    @GetMapping("/get")
    public List<tblNguoidung> getallNguoidung(){
        return nguoiDungDetailService.getAll();
    }
}
