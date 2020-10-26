package javaBase.concurrentProgramming.multiThreading.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * description:
 *  几种常用的线程池:
 *     newFixedThreadPool（固定数目线程的线程池，内部使用LinkedBlockingQueue） 适用于处理CPU密集型的任务，确保CPU在长期工作线程使用的情况下，尽可能少的分配线程。
 *     newCachedThreadPool（可缓存线程的线程池，内部使用SynchronousBlockingQueue） 用于并发量大执行大量短期的小任务。
 *     newSingleThreadPool（单线程的线程池，内部使用LinkedBlockingQueue）适用于串行执行任务的情景，一个任务接一个任务的执行。
 *     newScheduledThreadPool（定时及周期性执行的线程池，内部使用DelayQueue） 周期性的执行任务的场景，做一些简单的定时调度。
 * @Author: Wjh
 * @Date: 2020/9/30 11:01
 * @Modified By:
 */
public class ThreadPoolUseTest {

    /**
     * Description: 阿里巴巴推荐的创建线程池方式
     *
     * corePoolSize：核心线程的数量
     * maximumPoolSize：线程池中最大的线程数量
     * keepAliveTime：线程池中非核心线程空闲的存活时间
     * TimeUnit：线程空闲存活时间的时间单位
     * workQueue：存放任务的阻塞队列
     * threadFactory：用于创建核心线程的线程工厂，可以给创建的线程自定义名字，方便查日志
     * handler：线程池的饱和策略（拒绝策略），有四种类型。
     *
     * @Author: Wjh
     * @Date: 2020/10/12 16:31
     * Modified By:
     */
    @Test
    public void whenCreateThreadPoolSuccess() {
        // 指定线程名格式
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }
}
