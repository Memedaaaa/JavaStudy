package thread.createAThread;

public class MyThread extends Thread {
    public void run() {
        for (int a = 0; a < 3; a++) {
            try {
                Thread.sleep(100);
                System.out.println("thread.createAThread.MyThread：" + Thread.currentThread().getName() + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
