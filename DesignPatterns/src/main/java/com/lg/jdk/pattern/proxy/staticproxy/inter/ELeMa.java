package com.lg.jdk.pattern.proxy.staticproxy.inter;


/**
 * 静态代理模式，代理对象
 */
public class ELeMa implements Customer {

    private Customer customer;

    public ELeMa(Customer customer){
        this.customer = customer;
    }

    @Override
    public String order(String name) {
        String result = customer.order(name);
        System.out.println("去取餐。。。");
        System.out.println("去送餐。。。");
        return result+",已经送到。。。";
    }
}
