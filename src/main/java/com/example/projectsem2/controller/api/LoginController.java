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
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/account")
public class LoginController {

    @Autowired
    NguoiDungDetailServiceImpl nguoiDungDetailService;
    @Autowired
    RoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }

    public Boolean testUsingStrictRegex(String emailAddress) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return patternMatches(emailAddress, regexPattern);
    }

    @PostMapping("/register")
    public ResponseEntity<responseObject> saveUser(@RequestBody RegisterAccount registerAccount){
        try{
            Boolean checkEmail=testUsingStrictRegex(registerAccount.getEmail());
            Boolean checkNumber = registerAccount.getPhoneNumber().startsWith("0");


            if (checkEmail.equals(false)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new responseObject("false","Email không hợp lệ !",""));

            }
            if(registerAccount.getPhoneNumber().length() <10 || registerAccount.getPhoneNumber().length() >12 || checkNumber.equals(false)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new responseObject("false","Số điện thoại phải lớn hơn hoặc = 10 và bắt đầu từ 0 !",""));

            }if (registerAccount.getPassword().length() <8){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new responseObject("false","Mật khẩu phải từ 8 ký tự trở lên !",""));

            }
            if (nguoiDungDetailService.checkEmailExist(registerAccount.getEmail())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new responseObject("false","tài khoản đã tồn tại",""));
            }
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

        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new responseObject("false" ," Tạo tài khoản Không thành công ",ex.getLocalizedMessage()));
        }
    }

    @GetMapping("/get")
    public List<tblNguoidung> getallNguoidung(){
        return nguoiDungDetailService.getAll();
    }
}
