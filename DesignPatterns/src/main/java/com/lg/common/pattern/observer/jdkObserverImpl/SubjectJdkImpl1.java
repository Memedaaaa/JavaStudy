package com.lg.common.pattern.observer.jdkObserverImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 16:24 2020/4/20
 */

public class SubjectJdkImpl1 extends Observable {

    private String msg;

    public String getMsg() {
        return msg;
    }

    /**
     * 被订阅者更新消息
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}
