package com.lg.common.pattern.factory.simple;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 0:05 2020/4/21
 */

public class RouJiaMoFather implements RouJiaMo{
    public String type;

    public RouJiaMoFather(String type){
        this.type = type;
        System.out.println(type);
        prepare();
        fire();
        pack();
    }

    @Override
    public void prepare() {

    }

    @Override
    public void fire() {

    }

    @Override
    public void pack() {

    }
}
