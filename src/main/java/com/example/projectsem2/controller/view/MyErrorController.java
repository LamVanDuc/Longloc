package com.example.projectsem2.controller.view;

import com.example.projectsem2.Service.NguoiDungService;
import com.example.projectsem2.entity.tblNguoidung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class MyErrorController implements ErrorController {

    @Autowired
    NguoiDungService nguoiDungService;

        @RequestMapping("/error")
        public String handleError(HttpServletRequest request , Model model) {
            Optional<tblNguoidung> nguoidungOptinal = nguoiDungService.findByEmail();


            if (nguoidungOptinal.isPresent()){
                model.addAttribute("nguoidung",nguoidungOptinal.get());
            }else{
                model.addAttribute("nguoidung",null);
            }
            //do something like logging\
            Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

            if (status != null) {
                Integer statusCode = Integer.valueOf(status.toString());

                if(statusCode == HttpStatus.NOT_FOUND.value()) {
                    return "/error-404";
                }
                else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                    return "/error-500";
                }else if (statusCode  == HttpStatus.ACCEPTED.value()){
                    return "/error-403";
                }
                else if (statusCode  == HttpStatus.METHOD_NOT_ALLOWED.value()){
                    return "/error-405";
                }
            }
            return "/error";


         }
}
