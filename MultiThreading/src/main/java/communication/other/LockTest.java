package communication.other;

public class LockTest {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 无锁的两个线程，他们交叉执行
         */
//        new Thread(new ThreadA()).start();
//        new Thread(new ThreadB()).start();

        /**
         * 无锁的两个线程，他们顺序执行
         */
        new Thread(new LockThreadA()).start();
        new Thread(new LockThreadB()).start();


    }


    static class ThreadA implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread A " + i);
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread B " + i);
            }
        }
    }

    private static Object lock = new Object();

    static class LockThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("LockThreadA A " + i);
                }
            }
        }
    }

    static class LockThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("LockThreadB B " + i);
                }
            }
        }
    }
}
