package thread.createAThread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int b = 0; b < 3; b++) {
            try {
                Thread.sleep(100);
                System.out.println("Runnable："+Thread.currentThread().getName()+b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
