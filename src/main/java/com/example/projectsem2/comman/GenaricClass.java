package com.example.projectsem2.comman;

import java.sql.Date;

import java.time.Instant;
import java.util.Calendar;

public class GenaricClass {
    public static final String TRANGTHAI_dangCho ="Chờ xác nhận";
    public static final String TRANGTHAI_daXacNhan = "Đã xác nhận";

    public static final String TRANGTHAI_dangGiao ="Đang giao";
    public static final String TRANGTHAI_giaoKhongThanhCong ="Giao không thành công";
    public static final String TRANGTHAI_giaoThanhCong ="Giao thành công";
    public static final String TRANGTHAI_daNhanHang ="Đã nhận hàng";

    public static final String TRANGTHAI_daXoa ="Đơn hàng đã bị xóa";
    public static final String TRANGTHAI_huydonhang ="Đã hủy";

    public static Long idNguoidung(){
        return 3L;
    }

    public static Date dateTimeNow(){
        return  (Date) Date.from(Instant.now());
    }

    public static String idDonHang(){
        String idDonHang;
        Calendar calendar = Calendar.getInstance();

        String year = String.valueOf(calendar.get(Calendar.YEAR));
        year = year.substring(2);

        int month = calendar.get(Calendar.MONTH)+1;

        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String strMonth;
        if (month >=0 && month <=9){
            strMonth ="0"+String.valueOf(month);
        }else {
            strMonth = String.valueOf(month);
        }

        String stDay;
        if (day >=0 && day <=9){
            stDay ="0"+String.valueOf(day);
        }else {
            stDay = String.valueOf(day);
        }
        int dandom = (int) (Math.random() * 10000);

        idDonHang="DH"+ year + month + day +"L"+dandom;
        return idDonHang;
    }


    public static Date dayLater(int day){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, + day);
        Date todate = (Date) cal.getTime();
        return todate;
    }
}
