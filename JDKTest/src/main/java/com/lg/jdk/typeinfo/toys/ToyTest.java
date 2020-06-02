package com.lg.jdk.typeinfo.toys;

//有电池
interface HasBatteries {}

//能防水
interface Waterproof {}

//能拍摄
interface Shoots {}

interface Test{}

//玩具类和它的构造方法
class Toy {
    Toy() {}

    Toy(int i) {
    }
}

//儿童益智玩具
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}

//玩具测试类
public class ToyTest {

    static void printInfo(Class cc){
        System.out.println("Class name:"+cc.getName()+" is interface? ["+cc.isInterface()+ "]");
        System.out.println("Simple name:"+cc.getSimpleName());
        System.out.println("Canonical name:"+cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c =null;
        try {
            c = Class.forName("com.lg.jdk.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        printInfo(c);
        for (Class face:c.getInterfaces()){
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            //准备默认构造方法
            obj = up.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

