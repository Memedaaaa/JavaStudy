package communication;

public class ThreadLocalDemo {
    /**
     * ThreadLocal是一个本地线程副本变量工具类。内部是一个弱引用的Map来维护。
     * 有些朋友称ThreadLocal为 线程本地变量 或 线程本地存储。
     * 严格来说，ThreadLocal类并不属于多线程间的通信，而是让每个线程有自己”独立“的变量，线程之间互不影响。
     * 它为每个线程都创建一个副本，每个线程可以访问自己内部的副本变量。
     * <p>
     * ThreadLocal类最常用的就是set方法和get方法。
     */

    /**
     * 线程A
     */
    static class ThreadA implements Runnable {
        /**
         * 线程本地存储
         */
        private ThreadLocal<String> threadLocal;

        /**
         * 线程构造方法
         * @param threadLocal
         */
        public ThreadA(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        /**
         * 线程重写的run方法
         */
        @Override
        public void run() {
            threadLocal.set("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadA输出：" + threadLocal.get());
        }
    }

    /**
     * 线程B
     */
    static class ThreadB implements Runnable {
        private ThreadLocal<String> threadLocal;

        public ThreadB(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("B");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadB输出：" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("O");
        new Thread(new ThreadA(threadLocal)).start();
        new Thread(new ThreadB(threadLocal)).start();
    }

    /**
     * InheritableThreadLocal
     *
     * InheritableThreadLocal类与ThreadLocal类稍有不同，Inheritable是继承的意思。
     * 它不仅仅是当前线程可以存取副本值，而且它的子线程也可以存取这个副本值。
     */
}
