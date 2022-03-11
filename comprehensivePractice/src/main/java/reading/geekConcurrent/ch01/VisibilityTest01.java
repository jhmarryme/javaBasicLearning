package reading.geekConcurrent.ch01;

import lombok.SneakyThrows;
import org.junit.jupiter.api.RepeatedTest;

/**
 *
 * @author JiaHao Wang
 * @date 2022/3/9 下午3:28
 */
public class VisibilityTest01 {

    private long count = 0;

    @SneakyThrows
    @RepeatedTest(10)
    public void test() {
        // 创建两个线程，执行 add() 操作
        System.out.println(count);
        Thread thread1 = new Thread(this::add);
        Thread thread2 = new Thread(this::add);
        // 启动两个线程
        thread1.start();
        thread2.start();
        // 等待两个线程执行结束
        thread1.join();
        thread2.join();
        System.out.println(count);
        System.out.println("=====================");
    }

    private void add() {
        int idx = 0;
        while (idx++ < 100000000) {
            count += 1;
        }
    }
}
