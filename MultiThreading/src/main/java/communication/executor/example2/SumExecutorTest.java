package communication.executor.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 利用线程池计算1-1000的和
 */
public class SumExecutorTest {

    public static void main(String[] args) {
        //新建线程池
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        //新建结果集
        List<Future<Integer>> futureList = new ArrayList<>();
        //循环向线程池添加任务，并获取处理结果
        for (int i = 0; i < 10; i++) {
            SumExecutor task = new SumExecutor(i * 100 + 1, (i + 1) * 100);
            Future future = executor.submit(task);
            futureList.add(future);
        }

        //
        do {
            System.out.println("已完成任务数" + executor.getCompletedTaskCount());
            for (int i = 0; i < futureList.size(); i++) {
                Future<Integer> result = futureList.get(i);
                System.out.printf("Main: Task %d: %s\n", i, result.isDone());
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < futureList.size());

        int total = 0;
        for (int i=0; i<futureList.size(); i++) {
            Future<Integer> result=futureList.get(i);
            Integer sum=null;
            try {
                sum=result.get();
                total = total + sum;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("1-1000之和:" + total);

        // 线程池关闭
        executor.shutdown();
    }
}
