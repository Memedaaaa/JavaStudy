package communication.volatileDemo;

public class VolatileDemo01 {
    //volatile修饰的变量可以让所以线程看到它的变化
    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        //创建一个线程
        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (flag) {
                i++;
            }
            System.out.println(i);
        });

        //调用线程
        thread1.start();
        //主线程睡2秒
        Thread.sleep(2000);
        //将flag设置为false
        flag = false;
        //主线程退出
        System.out.println("主线程退出！");
    }


}

