package reading.geekConcurrent.ch02.p16Semaphore;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * Semaphore：快速实现一个资源池
 * @author JiaHao Wang
 * @date 2022/3/18 上午11:16
 */
public class ObjPool<T, R> {

    /** 模拟资源池 */
    private final List<T> pool;

    /** 用信号量实现限流器 */
    private final Semaphore sem;

    /** 初始化 */
    public ObjPool(int size, T t) {
        // 使用ArrayList会有线程安全问题
        pool = new Vector<>();
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        this.sem = new Semaphore(size);
    }

    /**
     * 利用对象池的对象，调用 func
     *
     * @author Jiahao Wang
     * @date 2022/3/18 上午11:23
     * @param function function
     * @return R
     */
    public R exec(Function<T, R> function) {
        T t = null;
        R r = null;
        try {
            // 1. P操作
            sem.acquire();
            // 2. 取出资源
            t = pool.remove(0);
            // 3. 使用资源
            r = function.apply(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 5. 归还资源
            pool.add(t);
            // 6, V操作
            sem.release();
        }
        return r;
    }
}
