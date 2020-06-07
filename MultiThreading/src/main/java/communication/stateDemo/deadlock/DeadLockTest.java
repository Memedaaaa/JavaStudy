package communication.stateDemo.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 规定资源的获取顺序，可避免死锁
 */
public class DeadLockTest {
    public static Integer r1 = 1;
    public static Integer r2 = 2;

    public static void main(String args[]) {
        TestThread51 t1 = new TestThread51();
        t1.start();
        TestThread52 t2 = new TestThread52();
        t2.start();
    }
}

class TestThread51 extends Thread {
    public void run() {
        synchronized (DeadLockTest.r1) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockTest.r2) {
                System.out.println("TestThread51 is running");
            }
        }
    }
}

class TestThread52 extends Thread {
    public void run() {
        synchronized (DeadLockTest.r1) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockTest.r2) {
                System.out.println("TestThread52 is running");
            }
        }
    }
}
