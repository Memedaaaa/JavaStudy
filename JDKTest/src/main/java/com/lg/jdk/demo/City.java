package com.lg.jdk.demo;

import lombok.Data;

@Data
public class City {
    private String type;
    private Properties properties;
    private Geometry geometry;
}
