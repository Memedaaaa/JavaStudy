package threadTest;

public class Test {
    /**
     * 把一个数尽量平均分为n份
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(4/3);
        System.out.println(5/3);
        System.out.println(10%3);
        Integer toMax = 100;
        int threads = 6;//计算线程数
        for (int i = 0; i < threads; i++) {
            //边界条件
            int start = toMax * i / threads + 1;
            int end = toMax * (i + 1) / threads;
            System.out.println(start+"---"+end+";"+(end-start));
        }
    }
}
