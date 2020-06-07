package communication.stateDemo.ProducterAndCusromer;

/**
 * 生产者不断生成产品
 * 消费者不断消费产品
 * 生产者和消费者都可以是若干个
 * 仓库的大小是有限的：当仓库满了，生产者不能存入；当仓库空了，消费者不能取出。
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        //新建仓库
        Warehouse warehouse = new Warehouse();

        //新建生产者
        Thread producer1 = new Thread(new Producer(warehouse));
        producer1.setName("生产者1");
        Thread producer2 = new Thread(new Producer(warehouse));
        producer2.setName("生产者2");
        //新建消费者
        Thread customer1 = new Thread(new Customer(warehouse));
        customer1.setName("消费者1");
        Thread customer2 = new Thread(new Customer(warehouse));
        customer2.setName("消费者2");

        //生产者生产商品
        producer1.start();
        producer2.start();
//        Thread.sleep(1000);
        //消费者消费商品
        customer1.start();
        customer2.start();
    }
}
