package communication.stateDemo.daemon;

/**
 * 守护线程
 * 结束：
 * 1.run方法结束；
 * 2.run未结束，main函数结束；
 * 注意：由于守护线程的结束可能不由自己决定，所以守护线程永远不要去访问资源，如文件或数据库。
 */
public class DaemonDemo {
    public static void main(String args[]) throws InterruptedException {
        TestThread4 t = new TestThread4();
        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);
        System.out.println("main thread is exiting");
    }
}

class TestThread4 extends Thread {
    public void run() {
        while (true) {
            System.out.println("TestThread4 is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
