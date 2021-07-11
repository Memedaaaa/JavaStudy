package com.lg.jdk.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//创建InvocationHandler接口的实现类
public class MyInvocationHandler implements InvocationHandler {
    //被代理对象，Object类型
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备插入数据");
        Object value = method.invoke(target, args);
        System.out.println("插入数据成功");
        return value;
    }
}