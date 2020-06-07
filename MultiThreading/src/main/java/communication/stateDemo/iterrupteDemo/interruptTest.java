package communication.stateDemo.iterrupteDemo;

/**
 * 主动中断线程
 * 被动中断线程
 */
public class interruptTest {
    public static void main(String[] args) throws InterruptedException {
        TestThread1 testThread1 = new TestThread1();
        TestThread2 testThread2 = new TestThread2();
        testThread1.start();
        testThread2.start();
        Thread.sleep(2000);
        testThread1.interrupt();
        testThread2.flag = false;
        System.out.println("主线程中断。。。");
    }

}

class TestThread1 extends Thread {
    @Override
    public void run() {
        //判断线程是否被中断
        while (!interrupted()) {
            System.out.println("线程"+Thread.currentThread().getName()+"-在运行。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }System.out.println("线程"+Thread.currentThread().getName()+"-被中断。。。");
    }

}

class TestThread2 extends Thread {
    public volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println("线程"+Thread.currentThread().getName()+"-在运行。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
        System.out.println("线程"+Thread.currentThread().getName()+"-被中断。。。");
    }
}
