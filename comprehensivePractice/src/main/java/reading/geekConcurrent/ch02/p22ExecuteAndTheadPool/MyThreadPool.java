package reading.geekConcurrent.ch02.p22ExecuteAndTheadPool;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 简化的线程池，仅用来说明工作原理
 * @author JiaHao Wang
 * @date 2022/3/22 上午10:29
 */
@Getter
public class MyThreadPool {

    /** 利用阻塞队列实现生产者 - 消费者模式 */
    private final BlockingQueue<Runnable> workQueue;

    /** 保存内部工作线程 */
    private final List<WorkThread> threads = new ArrayList<>();

    public MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int i = 0; i < poolSize; i++) {
            // 创建工作线程
            WorkThread workThread = new WorkThread();
            workThread.start();
            threads.add(workThread);
        }
    }

    /** 提交任务 */
    @SneakyThrows
    public void execute(Runnable runnable) {
        workQueue.put(runnable);
    }

    /** 工作线程负责消费任务，并执行任务 */
    class WorkThread extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            // 循环取任务并执行
            while (true) {
                Runnable runnable = workQueue.take();
                runnable.run();
            }
        }
    }

}
