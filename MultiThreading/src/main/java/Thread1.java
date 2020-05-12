import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * @auther: 李果
 * @date: 11:44 2020/5/12
 */

public class Thread1 {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int a= 0; a < 11; a++) {
                try {
                    Thread.sleep(100);
                    System.out.println("MyThread："+ Thread.currentThread().getName() + a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class MyRunnable implements Runnable {
        public void run() {
            for (int b = 0; b < 7; b++) {
                try {
                    Thread.sleep(100);
                    System.out.println("Runnable："+Thread.currentThread().getName()+b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new MyThread().start();

        MyRunnable m=new MyRunnable();
        new Thread(m).start();

        new Thread(()->{
            for (int c = 0; c < 12; c++) {
                try {
                    Thread.sleep(100);
                    System.out.println("Runnable函数式编程："+Thread.currentThread().getName()+c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
