package reading.geekConcurrent.ch02;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 快速实现一个缓存
 * @author JiaHao Wang
 * @date 2022/3/18 下午3:03
 */
public class CacheV1<K, V> {

    private final Map<K, V> m = new HashMap<>();

    private final ReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock rl = rwl.readLock();

    private final Lock wl = rwl.writeLock();

    public V get(K k) {
        V v = null;
        rl.lock();
        try {
            v = m.get(k);
        } finally {
            rl.unlock();
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
