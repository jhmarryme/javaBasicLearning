package reading.geekConcurrent.ch02.p24CompletableFuture.completionStage;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

/**
 * fn、consumer、action 它们的核心方法都不允许抛出可检查异常，但是却无法限制它们抛出运行时异常
 *
 * whenComplete() 和 handle() 系列方法就类似于 try{}finally{}中的 finally{}，
 *      无论是否发生异常都会执行 whenComplete() 中的回调函数 consumer 和 handle() 中的回调函数 fn。
 * whenComplete() 和 handle() 的区别在于 whenComplete() 不支持返回结果，而 handle() 是支持返回结果的
 *
 * CompletionStage exceptionally(fn);
 * CompletionStage<R> whenComplete(consumer);
 * CompletionStage<R> whenCompleteAsync(consumer);
 * CompletionStage<R> handle(fn);
 * CompletionStage<R> handleAsync(fn);
 *
 * @author JiaHao Wang
 * @date 2022/3/22 下午3:05
 */
public class P4CompletableFutureException {

    @Test
    @DisplayName("抛出运行时异常")
    public void whenRunFailed() {
        CompletableFuture<Integer> f0 = CompletableFuture
                .supplyAsync(() -> (7 / 0))
                .thenApply(r -> r * 10);
        System.out.println(f0.join());
    }

    @Test
    @DisplayName("exceptionally, 捕获运行时抛出的异常")
    public void whenCatchRuntimeExceptionSuccess() {
        CompletableFuture<Integer> f0 = CompletableFuture
                .supplyAsync(() -> (7 / 0))
                .thenApply(r -> r * 10)
                .exceptionally(throwable -> {
                    System.out.println(throwable.getMessage());
                    return null;
                });
        System.out.println(f0.join());
    }

    @RepeatedTest(5)
    @DisplayName("whenComplete， 将计算结果或者抛出的异常作为入参传递给回调通知函数")
    public void whenWhenCompleteSuccess() {
        CompletableFuture
                .supplyAsync(() -> {
                    int i = 1;
                    if (RandomUtils.nextBoolean()) {
                        i = 7 / 0;
                    }
                    return i;
                })
                // future2获得的结果是前置任务的结果，whenComplete中的逻辑不会影响计算结果
                .whenComplete((r, e) -> {
                    if (e != null) {
                        System.out.println("compute failed!");
                    } else {
                        System.out.println("received result is " + r);
                    }
                });
    }

    @RepeatedTest(5)
    @DisplayName("whenComplete， 独立的任务是捕获不到的")
    @Disabled
    public void whenWhenCompleteFailed() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int i = 1;
            if (RandomUtils.nextBoolean()) {
                i = 7 / 0;
            }
            return i;
        });

        CompletableFuture<Integer> future2 = future1.whenComplete((r, e) -> {
            // 不管future1是否抛出异常, 这里的e都是null
            if (e != null) {
                System.out.println("compute failed!");
            } else {
                System.out.println("received result is " + r);
            }
        });
        System.out.println("result: " + future2.join());
    }

    @RepeatedTest(5)
    @DisplayName("handle，与whenComplete的作用有些类似，但是handle接收的处理函数有返回值，而且返回值会影响最终获取的计算结果")
    public void whenHandleSuccess() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int i = 1;
            if (RandomUtils.nextBoolean()) {
                i = 7 / 0;
            }
            return i;
        });

        CompletableFuture<Integer> future2 = future1.handle((r, e) -> {
            if (e != null) {
                System.out.println("compute failed!");
                return r;
            } else {
                System.out.println("received result is " + r);
                return r + 10;
            }
        });
        System.out.println("result: " + future2.join());
    }

}
