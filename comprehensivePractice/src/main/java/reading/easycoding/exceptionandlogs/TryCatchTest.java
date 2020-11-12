package reading.easycoding.exceptionandlogs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description: 码出高效中的异常和日志章节学习
 * @Author: Wjh
 * @Date: 2020/11/11 17:39
 * @Modified By:
 */
@Slf4j
public class TryCatchTest {

    static int x = 1;
    static int y = 10;
    static int z = 100;

    @Test
    @DisplayName("try-catch代码块中使用return语句并在finally中操作返回结果")
    public void whenUseReturnInCatch() {
        // finally是在return表达式后运行,
        System.out.println("finallyNotWork() = " + finallyNotWork());
    }

    @Test
    @DisplayName("try-catch中使用lock")
    public void tryLock() {
        Lock lock = new ReentrantLock();
        // 锁必须紧跟try代码块
        lock.lock();
        try {
            // 如果在这里加锁, 当lock失败抛出异常后 会导致finally中的unlock也发生异常
            // lock.lock();
        } finally {
            // 必须放到finally第一行。
            lock.unlock();
        }
    }

    @Test
    @DisplayName("在finally中使用return语句")
    public void whenUseReturnInFinally() {
        // 返回值的判断会变得复杂
        System.out.println("finallyReturn() = " + finallyReturn());
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
    }

    public int finallyReturn() {
        try {
            // 无异常: return ++x 中的 ++x 被成功执行, 所以 x = 2; 有异常: x = 1
            return ++x;
        } catch (Exception e) {
            // 无异常: catch的内容不会被执行, y = 10; 有异常: y = 11, x = 1
            return ++y;
        } finally {
            // 最终的返回结果由 return ++z完成, z = 101
            return ++z;
        }
    }

    public int finallyNotWork() {
        int temp = 10000;
        try {
            throw new Exception();
        } catch (Exception e) {
            return ++temp;
        } finally {
            // 此时return的结果已被暂存, 待finally执行后返回, finally中对返回结果的操作不起作用
            temp = 99999;
            System.out.println("finally中其他的操作会被执行");
        }
    }
}
