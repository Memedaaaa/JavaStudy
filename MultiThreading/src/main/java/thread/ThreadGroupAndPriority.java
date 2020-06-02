package thread;

import java.util.stream.IntStream;

/**
 * Java中线程优先级可以指定，范围是1~10。
 *
 * 但是并不是所有的操作系统都支持10级优先级的划分（比如有些操作系统只支持3级划分：低，中，高）
 *
 * Java只是给操作系统一个优先级的参考值，线程最终在操作系统的优先级是多少还是由操作系统决定
 *
 * Java默认的线程优先级为5，线程的执行顺序由调度程序来决定，线程的优先级会在线程被调用之前设定
 *
 * 通常情况下，高优先级的线程将会比低优先级的线程有更高的几率得到执行。我们使用方法Thread类的setPriority()实例方法来设定线程的优先级
 *
 */
public class ThreadGroupAndPriority {
    public static void main(String[] args) {
        ThreadGroupAndPriority threadPriority = new ThreadGroupAndPriority();

        threadPriority.getPriorityOfThreadAndThreadGroup();
        threadPriority.getPriorityOfThread();
        threadPriority.enumerate();
        threadPriority.dealWithExceptionOfThreadGroup();
    }

    /**
     * 优先级并不绝对决定线程执行先后
     */
    public void getPriorityOfThread(){
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }

    /**
     * 线程和线程组的优先级不一致的时，按照谁的优先级为准
     */
    public void getPriorityOfThreadAndThreadGroup(){
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup,"thread");
        thread.setPriority(9);
        System.out.println("我是线程组的优先级"+threadGroup.getMaxPriority());
        System.out.println("我是线程的优先级"+thread.getPriority());
    }

    /**
     * 复制线程组
     */
    public void enumerate(){
        ThreadGroup oldThreadGroup = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[oldThreadGroup.activeCount()];
        ThreadGroup newThreadGroup = new ThreadGroup("newThreadGroup");
        newThreadGroup.enumerate(threads);
        System.out.println(newThreadGroup.toString());
    }

    /**
     * 线程组统一异常处理
     */
    public void dealWithExceptionOfThreadGroup(){
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            // 继承ThreadGroup并重新定义以下方法
            // 在线程成员抛出unchecked exception
            // 会执行此方法
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };
        // 这个线程是threadGroup1的一员
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            public void run() {
                // 抛出unchecked异常
                throw new RuntimeException("测试异常");
            }
        });

        thread1.start();
    }

    public static class T1 extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                    Thread.currentThread().getName(),
                    Thread.currentThread().getPriority()));
        }
    }
}
