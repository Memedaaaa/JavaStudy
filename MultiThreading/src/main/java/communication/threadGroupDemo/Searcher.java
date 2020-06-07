package communication.threadGroupDemo;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Searcher implements Runnable {

    private Result result;

    public Searcher(Result result) {
        this.result=result;
    }

    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        System.out.printf("Thread %s: 线程开始执行。。。",name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: 线程中断。。。",name);
            return;
        }
        System.out.printf("Thread %s: 线程完成，，，",name);
    }

    private void doTask() throws InterruptedException {
        Random random=new Random((new Date()).getTime());
        int value=(int)(random.nextDouble()*100);
        System.out.printf("Thread %s: %d",Thread.currentThread().getName(),value);
        TimeUnit.SECONDS.sleep(value);
    }
}
