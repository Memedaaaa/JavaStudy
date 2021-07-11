package com.lg.jdk.proxy.sta;

//被代理类
public class IUserServiceImpl implements IUserService{
    @Override
    public void add(String name) {
        System.out.println("插入数据："+name);
    }
}
