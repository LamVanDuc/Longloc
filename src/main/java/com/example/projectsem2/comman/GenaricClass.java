package com.example.projectsem2.comman;

import java.sql.Date;

import java.text.SimpleDateFormat;
import java.time.Instant;

public class GenaricClass {
    public static Long idNguoidung(){
        return 3L;
    }

    public static Date dateTimeNow(){
        return  (Date) Date.from(Instant.now());
    }

    public static String idDonHang(){
        String idDonHang;
        int random = (int) (Math.random()*1000);
        String strRandom = String.valueOf(random);
        Date dateNow = (Date) Date.from(Instant.now());

        SimpleDateFormat formatterYear = new SimpleDateFormat("yy");
        String year= formatterYear.format(dateNow);

        SimpleDateFormat formatterMonth = new SimpleDateFormat("MM");
        String moth = formatterMonth.format(dateNow);

        SimpleDateFormat formatterDay = new SimpleDateFormat("dd");
        String day = formatterMonth.format(dateNow);


        idDonHang="DH"+ year + moth + day +strRandom;

        return idDonHang;
    }
}
