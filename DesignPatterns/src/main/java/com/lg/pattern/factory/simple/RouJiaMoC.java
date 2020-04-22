package com.lg.pattern.factory.simple;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 23:13 2020/4/20
 */

public class RouJiaMoC extends RouJiaMoFather {

    public RouJiaMoC(String type) {
        super(type);
    }

    @Override
    public void prepare() {
        System.out.println("准备-C肉夹馍==="+type);
    }

    @Override
    public void fire() {
        System.out.println("烘焙-C肉夹馍==="+type);
    }

    @Override
    public void pack() {
        System.out.println("包装-C肉夹馍==="+type);
    }
}
