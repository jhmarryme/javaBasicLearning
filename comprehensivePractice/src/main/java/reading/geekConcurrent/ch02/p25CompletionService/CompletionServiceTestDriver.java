package reading.geekConcurrent.ch02.p25CompletionService;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 用三个线程异步执行，通过三次调用 Future 的 get() 方法获取结果，之后将询价结果保存在数据库中(模拟) 不同的处理方式
 *
 * @author JiaHao Wang
 * @date 2022/3/24 下午4:44
 */
public class CompletionServiceTestDriver {

    /**
     * 方式1-1:
     *      直接在主线程使用future.get() 获取执行结果并处理
     *      需要注意的是: 若 f1 的耗时很长，那么即便 f2 的耗时很短，也无法让保存 f2 的操作先执行，因为这个主线程都阻塞在了 f1.get() 操作上
     */
    @Test
    @DisplayName("在主线程执行直接future.get()是会造成阻塞的")
    @SneakyThrows
    public void whenFutureMainThreadBlocked() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // f1需要11秒
        Future<Integer> f1 = executor.submit(() -> {
            sleep(11);
            return 1;
        });
        // f2需要1秒
        Future<Integer> f2 = executor.submit(() -> {
            sleep(1);
            return 2;
        });
        // f3需要4秒
        Future<Integer> f3 = executor.submit(() -> {
            sleep(4);
            return 3;
        });
        // 在主线程执行future.get(), 就算后续的future执行完了, 还是得等第一个future任务拿到结果, 主线程会被阻塞
        Integer r1 = f1.get();
        executor.submit(() -> save(r1));
        Integer r2 = f2.get();
        executor.submit(() -> save(r2));
        Integer r3 = f3.get();
        executor.submit(() -> save(r3));
    }

    /**
     * 方式1-2:
     *      与方式1-1不同, 另外开启子线程处理 future.get()的返回结果, 不会造成主先线程的阻塞
     *      但实际使用需要注意线程的数量, 因为是一次性提交了6个任务, 所以如果线程池容量不够, 还是会受到影响
     */
    @Test
    @DisplayName("在子线程执行future.get()不会造成阻塞")
    @SneakyThrows
    public void whenFutureMainThreadNotBlocked() {
        // 这里不能设置为3了
        ExecutorService executor = Executors.newFixedThreadPool(4);
        // f1需要11秒
        Future<Integer> f1 = executor.submit(() -> {
            sleep(11);
            return 1;
        });
        // f2需要1秒
        Future<Integer> f2 = executor.submit(() -> {
            sleep(1);
            return 2;
        });
        // f3需要4秒
        Future<Integer> f3 = executor.submit(() -> {
            sleep(4);
            return 3;
        });
        // 在子线程执行future.get(), 不会造成主线程的阻塞
        executor.submit(() -> {
            try {
                save(f1.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            try {
                save(f2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            try {
                save(f3.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        TimeUnit.SECONDS.sleep(20);
    }

    /**
     * 方式1-3:
     *      1-2的改进版, 通过阻塞队列可以实现 获取到最先执行完成的结果
     */
    @Test
    @DisplayName("")
    @SneakyThrows
    public void whenMyFutureSuccess() {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        Future<Integer> f1 = executor.submit(() -> {
            sleep(11);
            return 1;
        });
        Future<Integer> f2 = executor.submit(() -> {
            sleep(1);
            return 2;
        });
        Future<Integer> f3 = executor.submit(() -> {
            sleep(3);
            return 3;
        });

        // 将future的结果存放到阻塞队列中
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        executor.submit(() -> {
            try {
                queue.put(f1.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            try {
                queue.put(f2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.submit(() -> {
            try {
                queue.put(f3.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        for (int i = 0; i < 3; i++) {
            Integer r = queue.take();
            executor.submit(() -> save(r));
        }
    }

    /**
     * 方式2-1:
     *      与1-3类似
     *      CompletionService 将线程池 Executor 和阻塞队列 BlockingQueue 的功能融合在了一起
     */
    @SneakyThrows
    @Test
    @DisplayName("使用ExecutorCompletionService时future任务的get方法不会造成阻塞")
    public void whenCompletionServiceSuccess() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        cs.submit(() -> {
            sleep(11);
            return 1;
        });
        cs.submit(() -> {
            sleep(1);
            return 2;
        });
        cs.submit(() -> {
            sleep(4);
            return 3;
        });

        for (int i = 0; i < 3; i++) {
            Integer r = cs.take().get();
            executor.submit(() -> save(r));
        }
    }

    /**
     * 若只想获取最快返回的任务执行结果, 丢弃后面未完成的任务
     *
     */
    @SneakyThrows
    @Test
    @DisplayName("使用CompletionService达到只选择最快的返回结果, 剩下的全部丢弃")
    public void whenCompletionServiceBreak() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        // 用于保存 Future 对象
        ArrayList<Future<Integer>> futures = new ArrayList<>();
        futures.add(
                cs.submit(() -> {
                    sleep(11);
                    return 1;
                })
        );
        futures.add(
                cs.submit(() -> {
                    sleep(1);
                    return 2;
                })
        );
        futures.add(
                cs.submit(() -> {
                    sleep(4);
                    return 3;
                })
        );
        // 获取最快返回的任务执行结果, 丢弃后面未完成的任务
        try {
            for (int i = 0; i < 3; i++) {
                Integer r = cs.take().get();
                // 简单地通过判空来检查是否成功返回
                if (r != null) {
                    executor.submit(() -> save(r));
                    // 只要有一个成功返回，则 break,
                    break;
                }
            }
        } finally {
            // 取消所有任务
            for (Future<Integer> future : futures) {
                future.cancel(true);
            }
        }
    }

    public void save(Integer r) {
        System.out.println("saved: " + r);
    }

    void sleep(int t) {
        try {
            TimeUnit.SECONDS.sleep(t);
        } catch (InterruptedException ignored) {
        }
    }
}
