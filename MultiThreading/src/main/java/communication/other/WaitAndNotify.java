package communication.other;

public class WaitAndNotify {
    private static Object lock = new Object();

    /**
     * 两个线程交替打印1-100
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            //获得同步锁，开始执行
            synchronized (lock) {
                for (int i = 0; i <= 100; i+=2) {
                    try {
                        //执行程序
                        System.out.println("ThreadA: " + i);
                        //叫醒另一个等待的线程
                        lock.notify();
                        //让自己等待
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //要是自己执行完了，也要叫醒别人
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 1; i <= 100; i+=2) {
                    try {
                        System.out.println("ThreadB: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }


//    public static void main(String[] args) throws InterruptedException {
//
//        Thread threadA = new Thread(() -> {
//            synchronized (lock) {
//                for (int i = 0; i < 5; i++) {
//                    try {
//                        System.out.println("ThreadA: "+Thread.currentThread().getName() + i);
//                        lock.notify();
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                lock.notify();
//            }
//        });
//        Thread threadB = new Thread(() -> {
//            synchronized (lock) {
//                for (int i = 0; i < 5; i++) {
//                    try {
//                        System.out.println("ThreadB: " +Thread.currentThread().getName()+ i);
//                        lock.notify();
//                        lock.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                lock.notify();
//            }
//        });
//
//        threadA.start();
//        Thread.sleep(1000);
//        threadB.start();
//    }


}
