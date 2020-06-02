package com.lg.jdk.pattern.proxy.staticproxy;

import com.lg.jdk.pattern.proxy.staticproxy.extend.Customer;
import com.lg.jdk.pattern.proxy.staticproxy.extend.MeiTuan;
import com.lg.jdk.pattern.proxy.staticproxy.inter.CustomerImpl;
import com.lg.jdk.pattern.proxy.staticproxy.inter.ELeMa;

/**
 * 静态代理测试类
 */
public class StaticTest {

    public static void main(String[] args) {
//        //创建一个静态代理对象
//        Customer proxy = new MeiTuan();
//        String result = proxy.order("银耳汤");
//        System.out.println(result);

        //创建一被代理对象
        CustomerImpl proxy = new CustomerImpl();
        //创建一个代理对象
        ELeMa eLeMa = new ELeMa(proxy);

        String result = eLeMa.order("红嫂肉");
        System.out.println(result);
    }
}
