package com.example.projectsem2.comman;

import java.sql.Date;
import java.time.Instant;

public class GenaricClass {

    public static Date dateTimeNow(){
        return  (Date) Date.from(Instant.now());
    }
}
