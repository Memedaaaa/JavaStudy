package com.lg.jdk.pattern.proxy.dynamicproxy.jdk;

public class JdkCustomerImpl implements JdkCustomer {
    @Override
    public String test1() {
        System.out.println("test1");
        return "test1";
    }

    @Override
    public void test2() {
        System.out.println("test2");
    }

    @Override
    public void test3() {
        System.out.println("test3");
    }
}
