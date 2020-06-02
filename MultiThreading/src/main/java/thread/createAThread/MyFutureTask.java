package thread.createAThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyFutureTask implements Callable {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread()+"子线程在进行计算");
        // 模拟计算需要一秒
        Thread.sleep(1000);
        return 2;
    }
}
