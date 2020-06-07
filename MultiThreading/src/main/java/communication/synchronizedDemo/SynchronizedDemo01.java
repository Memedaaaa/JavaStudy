package communication.synchronizedDemo;

/**
 * 多线程信息共享-关键步骤加锁限制
 * -互斥：某个线程运行一个代码块（关键区），其他线程不能同时运行这个代码段
 * -同步：多个线程的运行，必须按照某中规定的先后顺序来运行
 * -互斥是同步的一种特例
 * 互斥的关键字是-synchronized
 * -synchronized代码块/函数，只能一个线程进入
 * -synchronized加大性能负担，但是使用简便
 */
public class SynchronizedDemo01 {

    public static void main(String[] args) {
        MyThread t = new MyThread();
        Thread thread1 = new Thread(t, "线程1");
        Thread thread2 = new Thread(t, "线程2");
        Thread thread3 = new Thread(t, "线程3");
        Thread thread4 = new Thread(t, "线程4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class MyThread implements Runnable {

    private volatile int tickets = 100;

    @Override
    public void run() {
        while (true) {
            sale();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
    }

    public synchronized void sale() {
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + tickets);
            tickets--;
        }
    }
}
