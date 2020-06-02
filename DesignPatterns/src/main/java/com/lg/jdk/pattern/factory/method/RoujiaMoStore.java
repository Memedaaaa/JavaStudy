package com.lg.jdk.pattern.factory.method;

import com.lg.jdk.pattern.factory.simple.RouJiaMo;

/**
 * Description:工厂方法模式-总店
 *
 * @auther: 李果
 * @date: 14:40 2020/4/21
 */


public abstract class RoujiaMoStore
{

    public abstract RouJiaMo createRouJiaMo(String type);

    /**
     * 根据传入类型卖不同的肉夹馍
     *
     * @param type
     * @return
     */
    public RouJiaMo sellRouJiaMo(String type)
    {
        RouJiaMo rouJiaMo = createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;
    }

}
