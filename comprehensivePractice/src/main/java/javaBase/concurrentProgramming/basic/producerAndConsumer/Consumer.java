package javaBase.concurrentProgramming.basic.producerAndConsumer;

/**
 * 消费者
 * @author jhmarryme.cn
 * @date 2019/7/15 11:24
 */
public class Consumer extends Thread {
    Product product;

    public Consumer(String name, Product product) {
        super(name);
        this.product = product;
    }

    @Override
    public void run() {
        while (true){
            synchronized (product){
                String name = Thread.currentThread().getName();
                if (!product.flag) {
                    try {
                        product.wait();
                        System.out.println(name + " : 产品未生产, 正在等待");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(name + "正在消费产品" + product.color + product.size);
                product.flag = false;
                product.notify();
            }
        }
    }
}
