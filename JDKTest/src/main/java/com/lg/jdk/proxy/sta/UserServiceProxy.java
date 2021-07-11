package com.lg.jdk.proxy.sta;

public class UserServiceProxy implements IUserService {
    // 被代理对象
    private IUserService target;

    // 通过构造方法传入被代理对象
    public UserServiceProxy(IUserService target) {
        this.target = target;
    }

    @Override
    public void add(String name) {
        System.out.println("准备插入数据");
        target.add(name);
        System.out.println("插入数据成功");

    }
}
