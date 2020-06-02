package com.lg.jdk.pattern.proxy.staticproxy.extend;

/**
 * 被代理类
 */
public class Customer {
    public String order(String name){
        String result = "已经点餐："+name;
        return result;
    }
}
