package com.lg.jdk.multithread;

public class CreateThread {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();

        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("通过继承Thread方式创建了一个线程！");
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("通过实现Runnable方式创建了一个线程");
    }
}
