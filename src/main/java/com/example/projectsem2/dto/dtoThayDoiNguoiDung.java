package com.example.projectsem2.dto;

public class dtoThayDoiNguoiDung {
    private String password ;
    private String newPassword;
    private String phoneNumber;

    public dtoThayDoiNguoiDung(String password, String newPassword, String phoneNumber) {
        this.password = password;
        this.newPassword = newPassword;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
