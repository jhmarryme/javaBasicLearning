package reading.geekConcurrent.ch02.p18StampedLock;

import java.util.concurrent.locks.StampedLock;

/**
 * StampedLock 乐观读的使用案例
 * @author JiaHao Wang
 * @date 2022/3/18 下午5:11
 */
public class Point {

    private int x, y;

    StampedLock sl = new StampedLock();

    public double distanceFromOrigin() {
        // 1. 乐观读
        long stamp = sl.tryOptimisticRead();
        // 读入局部变量, 读的过程数据可能被修改
        int curX = x, curY = y;
        // 2. 判断读操作期间, 是否有执行写操作
        if (!sl.validate(stamp)) {
            // 2.1 升级为悲观读锁
            stamp = sl.readLock();
            try {
                curX = x;
                curY = y;
            } finally {
                // 2.2 释放悲观读锁
                sl.unlockRead(stamp);
            }
        }
        // 3. 计算结果
        return Math.sqrt(
                curX * curX + curY * curY);
    }
}
