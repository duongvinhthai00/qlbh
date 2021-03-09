package com.quanlybanhang.qlbh.serviceImpl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimeService {
    public static Timestamp getTimeNow(){
        Date date = new Date(System.currentTimeMillis());
        Timestamp timestamp = new Timestamp(date.getTime());
        return  timestamp;
    }
}
