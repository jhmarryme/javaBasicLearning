package reading.geekConcurrent.ch02.p22ExecuteAndTheadPool;

import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author JiaHao Wang
 * @date 2022/3/22 上午10:37
 */
public class MyThreadPoolTestDrive {
    @SneakyThrows
    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(2);
        MyThreadPool threadPool = new MyThreadPool(10, queue);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> System.out.println("hello world1"));
            threadPool.execute(() -> System.out.println("hello world2"));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
