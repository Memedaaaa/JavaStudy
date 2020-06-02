package com.lg.jdk.pattern.factory.simple;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 23:06 2020/4/20
 */

public interface RouJiaMo {

    /**
     * 肉夹馍准备工作
     */
    public void prepare();

    /**
     * 肉夹馍烘焙
     */
    public void fire();

    /**
     * 使用你们的专用袋-包装
     */
    public void pack();

}
