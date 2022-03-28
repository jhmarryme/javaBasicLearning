package reading.geekConcurrent.ch02.p24CompletableFuture.completionStage;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * CompletionStage 接口里面描述 OR 汇聚关系，主要是 applyToEither、acceptEither 和 runAfterEither 系列的接口
 * 这些接口的区别也是源自 fn、consumer、action 这三个核心参数不同。
 *
 * CompletionStage applyToEither(other, fn);
 * CompletionStage applyToEitherAsync(other, fn);
 * CompletionStage acceptEither(other, consumer);
 * CompletionStage acceptEitherAsync(other, consumer);
 * CompletionStage runAfterEither(other, action);
 * CompletionStage runAfterEitherAsync(other, action);
 *
 * @author JiaHao Wang
 * @date 2022/3/22 下午3:05
 */
public class P3CompletableFutureOr {

    @Test
    @DisplayName("applyToEither，2个子任务中任意1个完成后执行")
    public void whenApplyToEitherSuccess() {

        // 任务1 返回1, 随机休眠1-5秒
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(RandomUtils.nextInt(1, 5));
            System.out.println("compute 1");
            return 1;
        });

        // 任务1 返回10, 随机休眠1-5秒
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(RandomUtils.nextInt(1, 5));
            System.out.println("compute 2");
            return 10;
        });

        // 任意一个任务完成就会执行, 这里的结果是不固定的
        CompletableFuture<String> future3 = future1.applyToEither(future2,
                integer -> "result " + integer);
        System.out.println(future3.join());
    }

    void sleep(int t) {
        try {
            TimeUnit.SECONDS.sleep(t);
        } catch (InterruptedException ignored) {
        }
    }
}
