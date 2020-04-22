package com.lg.pattern.observer.jdkObserverImpl;

import java.util.Observable;
import java.util.Observer;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 16:25 2020/4/20
 */

public class ObserverJdkImpl implements Observer {

    //订阅者更新订阅消息消息
    public void update(Observable o, Object arg) {
        if (o instanceof SubjectJdkImpl1) {
            SubjectJdkImpl1 subjectJdkImpl1 = (SubjectJdkImpl1) o;
            System.out.println("SubjectJdkImpl1's msg -- >" + subjectJdkImpl1.getMsg());
        }

        if (o instanceof SubjectJdkImpl2) {
            SubjectJdkImpl2 subjectJdkImpl2 = (SubjectJdkImpl2) o;
            System.out.println("subjectForSSQ's msg -- >" + subjectJdkImpl2.getMsg());
        }
    }
}
