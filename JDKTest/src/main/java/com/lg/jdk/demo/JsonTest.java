package com.lg.jdk.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class JsonTest {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss:SSS");
        String date1 =formatter.format(new Date());
        System.out.println(date1);
        String path = CityTrack.class.getClassLoader().getResource("cityTrack.json").getPath();
        String s = readJsonFile(path);
        JSONArray jsonArray = JSONObject.parseArray(s);
        DataResult dataResult = new DataResult();
        dataResult.setType("FeatureCollection");
        dataResult.setSize("900");
        //城市列表
        List<City> featuresList = new ArrayList<>();
        for(int i=0;i<jsonArray.size();i++){
            City cities =  new City();

            //properties
            Properties properties = new Properties();
            JSONObject city = (JSONObject) jsonArray.get(i);
            String name = city.getString("city");

            List<List<List<Double>>> coordinates = new ArrayList<>();
            //所有人轨迹列表
            JSONArray array = (JSONArray) city.get("tracks");
            for(int j=0 ;j<array.size();j++){
                //每个人的轨迹列表
                JSONArray person = (JSONArray) array.get(j);
              List<List<Double>> list2 = new ArrayList<>();
                //每一个人的点
                for (int k=0;k<person.size();k++){
                    JSONObject points = (JSONObject) person.get(k);
                    List<Double> list1 = new ArrayList<>();
                    list1.add(Double.parseDouble(String.valueOf(points.get("lng"))));
                    list1.add(Double.parseDouble(String.valueOf(points.get("lat"))));
                    //
//                    for (int l=0 ;l<2;l++){
//                        List<String> list = new ArrayList<>();
//                        list.add(String.valueOf(points.get("lng")));
//                        list.add(String.valueOf(points.get("lat")));
//                        list1.add(list);
//                    }
                    list2.add(list1);
                }
                coordinates.add(list2);
            }
//            System.out.println(coordinates);
            Geometry geometry = new Geometry();
            geometry.setType("Polygon");
            geometry.setCoordinates(coordinates);

            properties.setId(String.valueOf(UUID.randomUUID()));
            properties.setName(name);
            cities.setProperties(properties);
            cities.setGeometry(geometry);
            cities.setType("Feature");
            featuresList.add(cities);
        }
        dataResult.setFeatures(featuresList);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(dataResult);
        System.out.println(jsonObject);
        String date2 =formatter.format(new Date());
        System.out.println(date2);
    }

    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
