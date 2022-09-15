package com.example.projectsem2.config;

import com.example.projectsem2.Service.NguoiDungDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    NguoiDungDetailServiceImpl nguoiDungDetailService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        // không cần xác minh
        // web

        http.authorizeRequests().antMatchers("/admin/img/**").permitAll();
        http.authorizeRequests().antMatchers("/admin/login").permitAll();
        http.authorizeRequests().antMatchers("/admin/css/**").permitAll();
        http.authorizeRequests().antMatchers("/admin/js/**").permitAll();
        http.authorizeRequests().antMatchers("/admin/style.css").permitAll();
        http.authorizeRequests().antMatchers("/admin/fonst/**").permitAll();
        http.authorizeRequests().antMatchers("/fonst/**").permitAll();
        http.authorizeRequests().antMatchers("/js/**").permitAll();
        http.authorizeRequests().antMatchers("/Login/**").permitAll();
        http.authorizeRequests().antMatchers("/style.css","/static/**").permitAll();
        http.authorizeRequests().antMatchers("/css/**" , "/js/**").permitAll();
        http.authorizeRequests().antMatchers("/fonts/**").permitAll();
        http.authorizeRequests().antMatchers("/shop").permitAll();
        http.authorizeRequests().antMatchers("/index","/","/home").permitAll();
        http.authorizeRequests().antMatchers("/contact").permitAll();
        http.authorizeRequests().antMatchers("/api/account/register/user").permitAll();
        http.authorizeRequests().antMatchers("/blog").permitAll();
        http.authorizeRequests().antMatchers("/detail").permitAll();
        http.authorizeRequests().antMatchers("/login","/","/img/**", "/login*","/dangky","/dangky/**","/Login/**").permitAll();
        // api

        http.authorizeRequests().antMatchers("/api/v1/sanpham/**").permitAll();
        http.authorizeRequests().antMatchers("/api/v1/danhmuc/**").permitAll();
        http.authorizeRequests().antMatchers("/danhmuc/**").permitAll();
        http.authorizeRequests().antMatchers("/danhmuc/css/**").permitAll();
        http.authorizeRequests().antMatchers("/danhmuc/js/**").permitAll();
        http.authorizeRequests().antMatchers("/danhmuc/img/**").permitAll();
        http.authorizeRequests().antMatchers("/danhmuc/style.css").permitAll();
        http.authorizeRequests().antMatchers("/resources/**").permitAll();
        http.authorizeRequests().antMatchers("/search/**").permitAll();
        //phân quyền
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/error-403");

        //http.authorizeRequests().antMatchers("/**").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");


        // còn lại tất cả đều xác minh
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginProcessingUrl("/loginForm")
                .loginPage("/login")
                .defaultSuccessUrl("/index",true)
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true");



    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(nguoiDungDetailService).passwordEncoder(passwordEncoder());

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
