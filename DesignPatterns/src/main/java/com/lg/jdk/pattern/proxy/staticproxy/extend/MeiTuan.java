package com.lg.jdk.pattern.proxy.staticproxy.extend;

/**
 * 通过继承实现静态代理
 */
public class MeiTuan extends Customer {
    @Override
    public String order(String name) {
        String result = super.order(name);
        System.out.println("去取餐。。。");
        System.out.println("去送餐。。。");
        return result+",已经送到。。。";
    }
}
