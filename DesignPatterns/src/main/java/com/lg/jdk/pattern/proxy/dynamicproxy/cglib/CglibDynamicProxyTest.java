package com.lg.jdk.pattern.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxyTest {
    public static void main(String[] args) {
        //获取被代理对象
        CglibCustomer cglibCustomer = new CglibCustomer();

        //用cglib获取代理对象
        CglibCustomer proxyCustomer = (CglibCustomer) Enhancer.create(
                cglibCustomer.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        if ("test1".equals(method.getName())) {
                            String result = (String) method.invoke(cglibCustomer, objects);
                            System.out.println("test1被增强");
                            System.out.println(result);
                            return result;
                        } else {
                            System.out.println("其他方法不会增强");
                            return method.invoke(cglibCustomer, objects);
                        }
                    }
                });

        //调用代理对象的方法
        proxyCustomer.test1("name");
        proxyCustomer.test2();
        proxyCustomer.test3();
    }
}
