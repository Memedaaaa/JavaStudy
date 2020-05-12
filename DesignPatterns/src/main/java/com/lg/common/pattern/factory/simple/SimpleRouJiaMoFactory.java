package com.lg.common.pattern.factory.simple;

/**
 * Description:简单工厂模式
 *
 * @auther: 李果
 * @date: 23:04 2020/4/20
 */

public class SimpleRouJiaMoFactory {

    public RouJiaMoFather createRouJiaMo(String type) {
        RouJiaMoFather rouJiaMo = null;
        switch (type) {
            case "A":
                rouJiaMo = new RouJiaMoA(type);
                break;
            case "B":
                rouJiaMo = new RouJiaMoB(type);
                break;
            case "C":
                rouJiaMo = new RouJiaMoC(type);
                break;
            default:
                System.out.println("INVALID TYPE");
        }
        return rouJiaMo;
    }
}
