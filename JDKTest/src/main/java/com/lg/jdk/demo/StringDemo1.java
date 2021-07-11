package com.lg.jdk.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringDemo1 {
    public static void main(String[] args) {
        String adrr = "重庆市江北区五福路";
        Map addMap = new HashMap();
        String[] arr1 = adrr.split("省");
        if(arr1.length == 2){
            addMap.put("provice",arr1[0]);
            String[] arr2 = arr1[1].split("市");
            if(arr1.length == 2){
                addMap.put("city",arr2[0]);
                String[] arr3 = arr2[1].split("区");
                String[] arr4 = arr2[1].split("县");
                if(arr3.length == 2){
                    addMap.put("area",arr3[0]);
                }else {
                    addMap.put("area",arr4[0]);
                }
            }
        }else {
            addMap.put("provice",null);
            String[] arr2 = adrr.split("市");
            if(arr2.length == 2){
                addMap.put("city",arr2[0]);
                String[] arr3 = arr2[1].split("区");
                String[] arr4 = arr2[1].split("县");
                if(arr3.length == 2){
                    addMap.put("area",arr3[0]);
                }else {
                    addMap.put("area",arr4[0]);
                }
            }
        }
        System.out.println(addMap.toString());

    }
}
