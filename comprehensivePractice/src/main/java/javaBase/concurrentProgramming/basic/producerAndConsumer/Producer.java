package javaBase.concurrentProgramming.basic.producerAndConsumer;

/**
 * 生产者
 * @author jhmarryme.cn
 * @date 2019/7/15 11:18
 */
public class Producer extends Thread {

    Product product;

    public Producer(String name, Product product) {
        super(name);
        this.product = product;
    }


    @Override
    public void run() {

        int count = 0;
        while(true){
            synchronized (product){
                //存在未被消费的商品
                String name = Thread.currentThread().getName();
                if (product.flag){
                    try {
                        System.out.println(name + ": 存在未被消费的商品, 正在等待");
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name + "开始生产产品");
                if (count % 2 == 0) {
                    product.color = "绿色";
                    product.size = "大号";
                } else {
                    product.color = "红色";
                    product.size = "小号";
                }
                product.flag = true;
                System.out.println(name + "生产商品成功");
                System.out.println(name + "正在等待消费");
                product.notify();

            }
        }

    }
}
