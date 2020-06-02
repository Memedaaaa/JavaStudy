package thread;

import javafx.concurrent.Task;

import java.util.concurrent.*;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 11:44 2020/5/12
 */

public class ThreadTest {

    public static void main(String[] args) {

        /**
         继承Thead类，重写run()方法，调用start()方法。
         */
//        thread.createAThread.MyThread myThread = new thread.createAThread.MyThread();
//        myThread.start();

        /**
         *实现Runnable,重写run()方法，调用start()方法。
         */
//        thread.createAThread.MyRunnable m = new thread.createAThread.MyRunnable();
//        new Thread(m).start();

        /**
         *Runnable函数式编程实现
         */
//        new Thread(() -> {
//            for (int c = 0; c < 3; c++) {
//                try {
//                    Thread.sleep(100);
//                    System.out.println("Runnable函数式编程：" + Thread.currentThread().getName() + c);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        /**
         * Callable、Future
         */
//        /*创建一个线程池执行器*/
//        ExecutorService executor = Executors.newCachedThreadPool();
//        /*创建一个线程*/
//        thread.createAThread.MyCallable myCallable = new thread.createAThread.MyCallable();
//        /*调用submit将线程丢进线程池*/
//        Future<Integer> result = executor.submit(myCallable);
//        executor.shutdown();
//        System.out.println(Thread.currentThread()+"主线程在执行任务");
//        try {
//            System.out.println(Thread.currentThread()+"task运行结果" + result.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread()+"所有任务执行完毕");

        /**
         *Callable、FutureTask
         */
//        ExecutorService future = Executors.newCachedThreadPool();
//        FutureTask<Integer> futureTask = new FutureTask<>(new thread.createAThread.MyFutureTask());
//        future.submit(futureTask);
//        future.shutdown();
//        try {
//            System.out.println(Thread.currentThread()+"futureTask运行结果"+futureTask.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread()+"所有任务执行完毕");
    }
}
