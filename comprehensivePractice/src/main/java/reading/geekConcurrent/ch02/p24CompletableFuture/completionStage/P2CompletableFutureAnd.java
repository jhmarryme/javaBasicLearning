package reading.geekConcurrent.ch02.p24CompletableFuture.completionStage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

/**
 * CompletionStage 接口里面描述 AND 汇聚关系，主要是 thenCombine、thenAcceptBoth 和 runAfterBoth 系列的接口
 * 这些接口的区别也是源自 fn、consumer、action 这三个核心参数不同
 *
 * CompletionStage<R> thenCombine(other, fn);
 * CompletionStage<R> thenCombineAsync(other, fn);
 * CompletionStage<Void> thenAcceptBoth(other, consumer);
 * CompletionStage<Void> thenAcceptBothAsync(other, consumer);
 * CompletionStage<Void> runAfterBoth(other, action);
 * CompletionStage<Void> runAfterBothAsync(other, action);
 *
 * @author JiaHao Wang
 * @date 2022/3/22 下午3:05
 */
public class P2CompletableFutureAnd {

    @Test
    @DisplayName("thenCombine，2个子任务都完成后执行")
    public void whenThenCombineSuccess() {

        // 任务1 返回1
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 1");
            return 1;
        });
        // 任务1 返回10
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 2");
            return 10;
        });
        // 任务1和任务2都完成后会执行， 将两个子任务的返回值相加并作为返回值
        CompletableFuture<Integer> future3 = future1.thenCombine(future2, (r1, r2) -> r1 + r2 + 1);
        System.out.println("result: " + future3.join());
    }


    @Test
    @DisplayName("thenAcceptBoth，类似与thenCombine, 区别在于该方法不能有返回值")
    public void whenThenAcceptBothSuccess() {

        // 任务1 返回1
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 1");
            return 1;
        });
        // 任务1 返回10
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 2");
            return 10;
        });
        // 任务1和任务2都完成后会执行， 将两个子任务的返回值相加并打印
        future1.thenAcceptBoth(future2, (r1, r2) -> {
            System.out.println("r1 + r2 = " + (r1 + r2));
        });
    }

    @Test
    @DisplayName("runAfterBoth，类似与thenCombine, 区别在于该方法不能有返回值也不能接收参数")
    public void whenRunAfterBothSuccess() {

        // 任务1 返回1
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 1");
            return 1;
        });
        // 任务1 返回10
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 2");
            return 10;
        });
        // 任务1和任务2都完成后会执行， 这里收不到两个子任务的返回值
        future1.runAfterBoth(future2, () -> {
            System.out.println("all compute success");
        });
    }
}
