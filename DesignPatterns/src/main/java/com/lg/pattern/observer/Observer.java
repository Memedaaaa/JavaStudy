package com.lg.pattern.observer;

/**
 * Description:订阅者
 *
 * @auther: 李果
 * @date: 14:05 2020/4/20
 */

public interface Observer {
    /**
     * 订阅者更新消息
     * @param message
     */
    public void update(String message);
}
