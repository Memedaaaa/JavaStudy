package threadTest;

public class ThreadSum {
    public static void main(String[] args) throws InterruptedException {
        //开始数字
        int allStart = 1;
        //结束数字
        int allEnd = 1000000000;
        //定义线程数
        int count = 6;
        //定义线程数组
        SumThread[] sumThreads = new SumThread[count];
        //判断每个线程是否为标准线程
        int j = 0;
        for (int i = 0; i < sumThreads.length; i++) {
            int start, end, size;
            if (i < (count - allEnd % count)) {
                start = (allEnd / count) * i + 1;
                size = allEnd / count;
            } else {
                start = (allEnd / count) * i + 1 + j;
                size = allEnd / count + 1;
                j++;
            }
            end = start + size - 1;
            sumThreads[i] = new SumThread(start, end);
            sumThreads[i].start();
        }
        while (true) {
            Boolean flag = true;
            for (int i = 0; i < sumThreads.length; i++) {
                flag = sumThreads[i].getFlag();
            }
            if (flag) {
                break;
            }
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        long sum = 0;
        for (int i = 0; i < sumThreads.length; i++) {
            sum += sumThreads[i].getSum();
        }
        System.out.println("总和是:" + sum);
    }
}

class SumThread extends Thread {
    private int start;
    private int end;
    private long sum = 0;
    static volatile Boolean flag = false;

    public Boolean getFlag() {
        return flag;
    }

    public long getSum() {
        return sum;
    }

    public SumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + "--计算量" + (end - start + 1) + "(" + start + "-" + end + ")--计算的数字之和为：" + sum);
        flag = true;
    }
}
