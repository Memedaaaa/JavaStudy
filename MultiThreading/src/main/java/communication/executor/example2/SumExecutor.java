package communication.executor.example2;

import java.util.Random;
import java.util.concurrent.Callable;

public class SumExecutor implements Callable {

    private int start;
    private int end;
    private int sum = 0;

    public SumExecutor(int start,int end){
        this.end = end;
        this.start = start;
    }
    @Override
    public Object call() throws Exception {
        for(int i=start;i<=end;i++){
            sum += i;
        }
        Thread.sleep(new Random().nextInt(1000));
        System.out.printf("%s: %d\n",Thread.currentThread().getName(),sum);
        return sum;
    }
}
