package communication.executor.example1;

import java.util.Date;

public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Long duration = (long) (Math.random() * 1000);
            System.out.printf("%s: 任务 %s: 做任务要用 %d 毫秒\n", Thread.currentThread().getName(), name, duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: 任务 %s: 完成时间: %s\n", Thread.currentThread().getName(), name, new Date());
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }
}
