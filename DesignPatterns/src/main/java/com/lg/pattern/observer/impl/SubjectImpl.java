package com.lg.pattern.observer.impl;

import com.lg.pattern.observer.Observer;
import com.lg.pattern.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 14:09 2020/4/20
 */

public class SubjectImpl implements Subject {
    //被观察者名
    private String name;
    public SubjectImpl(String name) {
        this.name = name;
    }
    /**
     * 订阅者的集合
     */
    private List<Observer> observerList = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    public void notify(String message) {
        System.out.println(message);
        for(Observer o :observerList){
            o.update(message);
        }
    }
}
