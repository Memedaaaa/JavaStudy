package thread.find;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class FindTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建一个数组，包含一万个元素，每个元素都是1-100之间的随机数
        int[] numbers = new int[1000000];
        int targetNumber = 50;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }

        System.out.println("findBySerial = " + findBySerial(numbers, targetNumber));
        System.out.println("findByExecutor = " + findByExecutor(numbers, targetNumber));
        System.out.println("findByForkJoin = " + findByForkJoin(numbers, targetNumber));
    }


    //通过串行计算，查询这个数组中值为50的元素个数
    public static int findBySerial(int[] numbers, int targetNumber) {
        int cnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == targetNumber)
                cnt++;
        }
        return cnt;
    }

    //通过Executor线程池，查询这个数组中值为50的元素个数
    public static int findByExecutor(int[] numbers, int targetNumber) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        int increment = 1000; //每1000长度为一组
        int numOfThread = numbers.length / increment;
        CountDownLatch latch = new CountDownLatch(numOfThread);

        int startIndex = 0, endIndex = increment - 1;
        for (int i = 0; i < numOfThread; i++) {
            if (i == numOfThread - 1)
                endIndex = numbers.length - 1;
            executor.execute(new FindByExecutor(numbers, startIndex, endIndex, targetNumber, latch));
            startIndex = endIndex + 1;
            endIndex = endIndex + increment;
        }

        latch.await();
        executor.shutdown();
        return FindByExecutor.getSumCnt();
    }

    public static int findByForkJoin(int[] numbers, int targetNumber) throws InterruptedException, ExecutionException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = new FindByJoinTask(numbers, 0, numbers.length - 1, targetNumber);
        task = pool.submit(task);
        Integer cnt = task.get();
        pool.shutdown();
        return cnt;
    }
}

class FindByExecutor implements Runnable {
    //总数
    private static int sumCnt = 0;
    //数组
    private int[] numbers;
    //每个线程处理数组的开始值
    private int startIndex;
    //每个线程处理数组的结束值
    private int endIndex;
    //目标值
    private int targetNumber;
    //等待锁，等待所以线程计算完，再计算总数
    private CountDownLatch latch;

    public FindByExecutor(int[] numbers, int startIndex, int endIndex, int targetNumber, CountDownLatch latch) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.targetNumber = targetNumber;
        this.latch = latch;
    }

    @Override
    public void run() {
        int cnt = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (numbers[i] == targetNumber)
                cnt++;
        }

        synchronized (FindByExecutor.class) {
            sumCnt += cnt;
        }
        latch.countDown();
    }

    public static int getSumCnt() {
        return sumCnt;
    }
}

class FindByJoinTask extends RecursiveTask<Integer> {
    int[] numbers;
    int startIndex;
    int endIndex;
    int targetNumber;

    public FindByJoinTask(int[] numbers, int startIndex, int endIndex, int targetNumber) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.targetNumber = targetNumber;
    }

    @Override
    protected Integer compute() {
        int cnt = 0;
        if (endIndex - startIndex < 1000) {
            for (int i = startIndex; i <= endIndex; i++) {
                if (numbers[i] == targetNumber)
                    cnt++;
            }
        } else {
            int midIndex = (startIndex + endIndex) / 2;
            FindByJoinTask leftTask = new FindByJoinTask(numbers, startIndex, midIndex, targetNumber);
            FindByJoinTask rightTask = new FindByJoinTask(numbers, midIndex + 1, endIndex, targetNumber);

            invokeAll(leftTask, rightTask);
            //FindByJoinTask.join()--当线程执行完，返回返回
            cnt = rightTask.join() + leftTask.join();
        }

        return cnt;

    }

}