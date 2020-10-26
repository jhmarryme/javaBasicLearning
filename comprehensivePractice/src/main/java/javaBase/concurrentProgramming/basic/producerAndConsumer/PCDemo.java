package javaBase.concurrentProgramming.basic.producerAndConsumer;

/**
 * @author jhmarryme.cn
 * @date 2019/7/15 11:29
 */

public class PCDemo {

    /**
     * 测试生产者消费者问题
     * @param args
     */
    public static void main(String[] args) {
        Product product = new Product();
        new Producer("生产者", product).start();
        new Consumer("消费者", product).start();
    }
}
