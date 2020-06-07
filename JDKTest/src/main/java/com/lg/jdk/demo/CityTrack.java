package com.lg.jdk.demo;

import lombok.Data;

import java.util.List;

@Data
public class CityTrack {
    private String city;
    private List<List<Point>> tracks;
}
