package reading.geekConcurrent.ch02.p24CompletableFuture.completionStage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

/**
 * CompletionStage 接口里面描述串行关系，主要是 thenApply、thenAccept、thenRun 和 thenCompose 这四个系列的接口。
 *
 *  这些方法里面 Async 代表的是异步执行 fn、consumer 或者 action
 *
 * CompletionStage<R> thenApply(fn); 既能接收参数也支持返回值，所以 thenApply 系列方法返回的是CompletionStage<R>
 * CompletionStage<R> thenApplyAsync(fn);
 * CompletionStage<Void> thenAccept(consumer); 虽然支持参数，但却不支持回值，所以 thenAccept 系列方法返回的是CompletionStage<Void>
 * CompletionStage<Void> thenAcceptAsync(consumer);
 * CompletionStage<Void> thenRun(action); 既不能接收参数也不支持返回值，所以 thenRun 系列方法返回的也是CompletionStage<Void>
 * CompletionStage<Void> thenRunAsync(action);
 * CompletionStage<R> thenCompose(fn); 这个系列的方法会新创建出一个子流程，最终结果和 thenApply 系列是相同的。
 * CompletionStage<R> thenComposeAsync(fn);
 *
 * @author JiaHao Wang
 * @date 2022/3/22 下午3:04
 */
public class P1CompletableFutureSerial {

    @Test
    @DisplayName("thenApply, 连接前后有依赖的任务链，当前置任务1完成后，任务2根据任务1的结果再进行计算")
    public void whenThenApplySuccess() {
        // 任务1 返回1
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 1");
            return 1;
        });
        // 任务2 拿到任务1 的返回结果，再进行处理
        CompletableFuture<Integer> future2 = future1.thenApply((p) -> {
            System.out.println("compute 2");
            return p + 10;
        });

        // 最后的结果是11
        System.out.println("result: " + future2.join());
    }

    @Test
    @DisplayName("thenAccept, 类似与thenApply, 区别在于该方法不能有返回值")
    public void whenThenAcceptSuccess() {
        CompletableFuture.supplyAsync(() -> "hello World")
                // 虽然支持参数，但却不支持返回值, 输出HELLO WORLD
                .thenAccept(s -> System.out.println(s.toUpperCase(Locale.ROOT)))
                // 输出null
                .thenAccept(System.out::println);
    }

    @Test
    @DisplayName("thenRun, 类似与thenApply, 区别在于不能有返回值也不能接收参数")
    public void whenThenRunSuccess() {
        CompletableFuture.supplyAsync(() -> "hello World")
                .thenRun(() -> System.out.println("running"));
    }

    @Test
    @DisplayName("thenCompose，类似与thenApply, 区别在于会新创建出一个子流程，但最终结果和 thenApply 系列是相同的")
    public void whenThenComposeSuccess() {
        // 1. 先使用thenApply 达到同样的效果
        // 两个任务之间有前后依赖关系，但是连接任务又是独立的CompletableFuture
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 1");
            return 1;
        });
        // 这里会导致 嵌套的CompletableFuture<CompletableFuture<Integer>>
        CompletableFuture<CompletableFuture<Integer>> future2 =
                future1.thenApply((r) -> {
                    System.out.println("compute 2");
                    return CompletableFuture.supplyAsync(() -> r + 10);
                });
        System.out.println(future2.join().join());

        // =================================================================
        // 2. 使用thenCompose则不会导致嵌套的嵌套的CompletableFuture
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 3");
            return 1;
        });
        CompletableFuture<Integer> future4 = future3.thenCompose((r) -> CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 4");
            return r + 10;
        }));
        System.out.println(future4.join());
    }

}
