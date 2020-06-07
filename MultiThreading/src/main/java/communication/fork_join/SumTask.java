package communication.fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * 计算一段数的和
 */
public class SumTask extends RecursiveTask<Long> {
	
	private int start;
	private int end;

	public SumTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public static final int threadhold = 5;

	@Override
	protected Long compute() {
		Long sum = 0L;
		
		//校验数据长度是否能满足最小能处理的任务数
		boolean canCompute = (end - start) <= threadhold;
		//如果是，就进行计算；否则就将任务拆分
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum = sum + i;				
			}
		} else {
			//将任务拆分
			int middle = (start + end) / 2;

			//递归并执行任务
			SumTask subTask1 = new SumTask(start, middle);
			SumTask subTask2 = new SumTask(middle + 1, end);
			invokeAll(subTask1, subTask2);

			//让主线程等待子线程结束之后才继续运行。
			Long sum1 = subTask1.join();
			Long sum2 = subTask2.join();

			// ����ϲ�
			sum = sum1 + sum2;
		}
		return sum;
	}
}
