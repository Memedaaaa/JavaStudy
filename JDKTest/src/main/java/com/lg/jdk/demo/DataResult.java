package com.lg.jdk.demo;

import lombok.Data;

import java.util.List;

@Data
public class DataResult {
    private String type;
    private String size;
    private List<City> features;

}
