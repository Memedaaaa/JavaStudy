package communication.stateDemo.ProducterAndCusromer;

import java.util.Random;

/**
 * 生产者
 */
public class Producer implements Runnable{
    private Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        int i=0;
        Random r = new Random();
        while (i<10){
            i++;
            Product product = new Product(r.nextInt(1000)+"",Thread.currentThread().getName()+"--"+i);
            warehouse.push(product);
            System.out.println(Thread.currentThread().getName()+"--从仓库存入一件产品："+product.toString());
        }
    }
}
