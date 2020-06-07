package communication.stateDemo.ProducterAndCusromer;

/**
 * 消费者
 */
public class Customer implements Runnable{
   private Warehouse warehouse;

   public Customer(Warehouse warehouse){
       this.warehouse=warehouse;
   }


    @Override
    public void run() {
        int i=0;
        while (i<10){
            i++;
            Product product =  warehouse.pull();
            System.out.println(Thread.currentThread().getName()+"--从仓库取出一件产品："+product.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
