package com.lg.jdk.pattern.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyTest {

    public static void main(String[] args) {
        //创建一个被代理对象
        JdkCustomerImpl jdkCustomerImpl = new JdkCustomerImpl();
        //使用jdk的API创建一个代理对象
        JdkCustomer jdkCustomer = (JdkCustomer) Proxy.newProxyInstance(
                jdkCustomerImpl.getClass().getClassLoader(),
                jdkCustomerImpl.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("test1".equals(method.getName())) {
                            System.out.println("增强了test1方法。。。");
                            Object result =  method.invoke(jdkCustomerImpl, args);
                            return result;
                        } else {
                            System.out.println("其他方法不会增强。。。");
                            return method.invoke(jdkCustomerImpl, args);
                        }
                    }
                });

        //调用代理对象的方法
        jdkCustomer.test1();
        jdkCustomer.test2();
        jdkCustomer.test3();
    }
}
