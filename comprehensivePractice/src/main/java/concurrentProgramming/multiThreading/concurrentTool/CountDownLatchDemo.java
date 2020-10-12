package concurrentProgramming.multiThreading.concurrentTool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

/**
 * description: CountDownLatch具有计数器的功能，
 * 意思是主线程遇到CountDownLatch阻塞在那，要等待CountDownLatch里的所有线程都执行完毕，主线程才能继续执行。
 * 需要注意的是CountDownLatch创建的线程数和每个线程里countDown的总次数需要和初始化CountDownLatch传入的线程数相等，
 * 不然的话主线程将一直处于等待状态。
 * @Author: Wjh
 * @Date: 2020/9/25 10:14
 * @Modified By:
 */
public class CountDownLatchDemo {

    public static final int STUDENT_COUNT = 10;

    public static final CountDownLatch countDownLatch = new CountDownLatch(STUDENT_COUNT);

    @Test
    public void demo() {
        // 开启一个主线程, 当所有子线程都执行完毕后, 才会进行后续的操作
        new Thread(() -> {
            System.out.println("Teacher " + Thread.currentThread().getName() + " is starting");
            try {
                // 等待所有子线程就绪后 开始执行
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Teacher is running");
        }).start();

        // 开启n个子线程
        Stream.iterate(0, integer -> integer + 1).limit(10).forEach(integer -> {
            new Thread(() -> {
                System.out.println("Student " + Thread.currentThread().getName() + "is ready");
                // 执行完毕后, 子线程发起就绪指令
                countDownLatch.countDown();
            }).start();
        });
    }
}
