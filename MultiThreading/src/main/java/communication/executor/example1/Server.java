package communication.executor.example1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    //定义线程池
    private ThreadPoolExecutor executor;

    //构造方法
    public Server(){
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(5);
    }

    //提交任务
    public void submitTask(Task task){
        System.out.printf("Server: 一个新的任务到来\n"+task.toString());
        executor.execute(task); //执行任务
        System.out.printf("Server: 线程池大小: %d\n",executor.getPoolSize());
        System.out.printf("Server: 活跃线程数: %d\n",executor.getActiveCount());
        System.out.printf("Server: 已完成任务: %d\n",executor.getCompletedTaskCount());
    }

    //结束任务
    public void endServer() {
        executor.shutdown();
    }
}
