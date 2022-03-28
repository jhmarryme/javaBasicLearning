package reading.geekConcurrent.ch02.p24CompletableFuture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author JiaHao Wang
 * @date 2022/3/22 下午2:28
 */
public class CompletableFutureTestDrive {

    @Test
    @DisplayName("")
    public void whenSuccess() {
        // 任务 1：洗水壶 -> 烧开水
        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(() -> {
                    System.out.println("T1: 洗水壶...");
                    sleep(1);

                    System.out.println("T1: 烧开水...");
                    sleep(10);
                });

        // 任务 2：洗茶壶 -> 洗茶杯 -> 拿茶叶
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("T2: 洗茶壶...");
                    sleep(1);

                    System.out.println("T2: 洗茶杯...");
                    sleep(2);

                    System.out.println("T2: 拿茶叶...");
                    sleep(1);
                    return " 龙井 ";
                });

        // 任务 3：任务 1 和任务 2 完成后执行：泡茶
        CompletableFuture<String> f3 =
                // r1, r2分别是两个任务的返回值, 这里只用到r2, r1是null
                f1.thenCombine(f2, (r1, r2) -> {
                    System.out.println(r1);
                    System.out.println("T1: 拿到茶叶:" + r2);
                    System.out.println("T1: 泡茶...");
                    return " 上茶:" + r2;
                });

        // 等待任务 3 执行结果
        System.out.println(f3.join());
    }

    void sleep(int t) {
        try {
            TimeUnit.SECONDS.sleep(t);
        } catch (InterruptedException ignored) {
        }
    }
}
