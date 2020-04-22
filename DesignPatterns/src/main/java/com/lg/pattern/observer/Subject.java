package com.lg.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:被订阅者
 *
 * @auther: 李果
 * @date: 14:04 2020/4/20
 */

public interface Subject {
    /**
     * 增加订阅者
     * @param observer
     */
    public void attach(Observer observer);
    /**
     * 删除订阅者
     * @param observer
     */
    public void detach(Observer observer);
    /**
     * 通知订阅者更新消息
     */
    public void notify(String message);
}
