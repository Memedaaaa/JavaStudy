package communication.stateDemo.ProducterAndCusromer;

/**
 * 仓库
 */
public class Warehouse {
    //仓库大小
    private Product[] products = new Product[10];
    //仓库栈顶的数据
    private int top = 0;

    //存入仓库
    public synchronized void push(Product product) {
        //判断仓库是否已存满
        while (top == products.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //未存满时
        products[top++] = product;
        notifyAll();
    }

    //从仓库取出
    public synchronized Product pull() {
        //判断仓库是否还有产品
        while (top == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //还有产品时
        --top;
        Product product = new Product(products[top].getId(), products[top].getName());
        products[top] =null;
        notifyAll();
        return product;
    }


}
