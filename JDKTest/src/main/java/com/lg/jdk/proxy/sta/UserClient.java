package com.lg.jdk.proxy.sta;

public class UserClient {
    public static void main(String[] args) {
        IUserService target = new IUserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(target);
        proxy.add("小明");
    }
}
