package com.lg.common;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 9:41 2020/4/30
 */

public class ClassTest {
    //一个数组
    private static int[] array = new int[3];
    //length标识数组长度
    private static int length = array.length;

    private static Class<One> one = One.class;
    private static Class<Anther> anther = Anther.class;

    public static void main(String[] args) throws Exception{

        One oneObject = one.newInstance();
        oneObject.call();
    }
    class One {
        private String inner = " time flies .";
        public void call() {
            System . out.println (" hello world . " );
        }
        public String getInner(){
            return inner;
        }
    }

    class Anther{
        public void spreak(){
            System.out.println( "easy coding.");
        }
    }
}
