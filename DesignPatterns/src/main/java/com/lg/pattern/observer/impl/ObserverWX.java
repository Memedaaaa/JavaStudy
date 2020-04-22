package com.lg.pattern.observer.impl;

import com.lg.pattern.observer.Observer;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 14:09 2020/4/20
 */

public class ObserverWX implements Observer {
    // 订阅者名
    private String name;
    public ObserverWX(String name) {
        this.name = name;
    }
    public void update(String message) {
        System.out.println(this.name+"接收到消息:"+message);
    }
}
