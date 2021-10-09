package javaBase.concurrentProgramming.multiThreading;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture 使用
 * @author JiaHao Wang
 * @date 2021/9/24 下午3:28
 */
public class CompletableFutureTest {

    @SneakyThrows
    @Test
    @DisplayName("CompletableFuture简单的例子-阻塞")
    @Disabled
    public void whenSimpleUseSuccess() {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        // get() 方法同样会阻塞直到任务完成，因为这种方式创建的future从未完成
        // 这里的主线程会一直阻塞
        Integer integer = future.get();
        System.out.println(integer);
        System.out.println("success");
    }

    @Test
    @DisplayName("whenComplete， 前置任务会将计算结果或者抛出的异常作为入参传递给回调通知函数")
    public void whenWhenCompleteSuccess() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 1");
            return 1;
        });
        // future2获得的结果是前置任务的结果，whenComplete中的逻辑不会影响计算结果。
        CompletableFuture<Integer> future2 = future1.whenComplete((r, e) -> {
            if (e != null) {
                System.out.println("compute failed!");
            } else {
                System.out.println("received result is " + r);
            }
        });
        System.out.println("result: " + future2.join());
    }

    @Test
    @DisplayName("handle，与whenComplete的作用有些类似，但是handle接收的处理函数有返回值，而且返回值会影响最终获取的计算结果。")
    public void whenHandleSuccess() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("compute 1");
            return 1;
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
    @DisplayName("thenCompose， 连接前后有依赖的任务链，当前置任务1完成后，任务2根据任务1的结果再进行计算")
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

    @Test
    @DisplayName("thenCombine，将两个异步计算合并为一个，这两个异步计算之间相互独立，互不依赖")
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
        // 组合任务1和任务2， 将两个返回值相加
        CompletableFuture<Integer> future3 = future1.thenCombine(future2, (r1, r2) -> r1 + r2 + 1);
        System.out.println("result: " + future3.join());
    }

    @AfterEach
    public void whenPrintSuccess() {
        System.out.println("==================================================");
    }
}
