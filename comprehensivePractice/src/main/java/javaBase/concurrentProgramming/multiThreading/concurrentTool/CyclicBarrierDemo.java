package javaBase.concurrentProgramming.multiThreading.concurrentTool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.Stream;

/**
 * description: CyclicBarrier就是循环栅栏，意思是多个线程相互阻塞，只有多个线程都达到了栅栏时候，才能同时执行后续的逻辑。
 * 区别就是CountDownLatch是一个线程（或多个）等待另外的N个线程完成某个事情后才能执行。
 * CyclicBarrier是N个线程相互等待，任何一个线程达到栅栏前，所有线程都阻塞在那。
 * @Author: Wjh
 * @Date: 2020/9/27 12:05
 * @Modified By:
 */
public class CyclicBarrierDemo {

    public static final int WORKER_COUNT = 10;

    public static CyclicBarrier cyclicBarrier;

    @Test
    public void whenCyclicBarrierSuccess() {

        // 创建一个CyclicBarrier, 等待所有子线程就绪后执行
        cyclicBarrier = new CyclicBarrier(WORKER_COUNT, () -> {
            System.out.println(WORKER_COUNT + "个工人已就位，可以开始干活了...");
        });

        // 子线程相互等待, 当所有子线程都就位, 子线程才会继续后续的工作(先执行主线程)
        Stream.iterate(0, integer -> integer + 1).limit(WORKER_COUNT).forEach(integer -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 就位");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 在主线程后执行
                System.out.println(Thread.currentThread().getName() + " 开始干活了");
            }).start();
        });
    }
}
