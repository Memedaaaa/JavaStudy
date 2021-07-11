package com.lg.jdk.demo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class demo01 {
    public static void main(String[] args) {
        Format f =new SimpleDateFormat("yyyyMMdd");
        Date today =new Date();
        System.out.println(f.format(today));
        Calendar c =Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.YEAR,50);
        today = c.getTime();
        System.out.println(f.format(today));
    }
}
