package reading.geekConcurrent.ch02;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 实现缓存的按需加载
 * @author JiaHao Wang
 * @date 2022/3/18 下午3:03
 */
public class CacheV2<K, V> {

    private final Map<K, V> m = new HashMap<>();

    private final ReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock rl = rwl.readLock();

    private final Lock wl = rwl.writeLock();

    public V get(K k) {
        V v = null;
        // 1. 读缓存
        rl.lock();
        try {
            v = m.get(k);
        } finally {
            rl.unlock();
        }
        // 2. 缓存中存在，返回
        if (v != null) {
            return v;
        }

        // 3. 缓存中不存在，查询数据库
        wl.lock();
        try {
            // 再次验证, 其他线程可能已经查询过数据库
            v = m.get(k);
            if (v == null) {
                // 查询数据库, 省略代码
                v = null;
                m.put(k, v);
            }
        } finally {
            wl.unlock();
        }
        return v;
    }

    public void put(K k, V v) {
        wl.lock();
        try {
            m.put(k, v);
        } finally {
            wl.unlock();
        }
    }
}
