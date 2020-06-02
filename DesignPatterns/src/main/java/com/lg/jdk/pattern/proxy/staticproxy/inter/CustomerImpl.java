package com.lg.jdk.pattern.proxy.staticproxy.inter;

/**
 * 静态代理模式，被代理对象
 */
public class CustomerImpl implements  Customer{
    @Override
    public String order(String name) {
        String result = "已经点餐："+name;
        return result;
    }
}
