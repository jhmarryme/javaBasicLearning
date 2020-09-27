package concurrentProgramming.multiThreading.concurrentTool;

import java.util.concurrent.Semaphore;

/**
 * description: Semaphore信号量，就是用来控制访问有限资源的线程数量，线程要访问资源首先要获得许可证，一个许可证对应一个资源，如果资源不足了，线程就要等待，
 * 如果其他线程释放了一个资源（许可证），那么信号量就通知等待的一个线程，分配给它一个许可证。内部实现这里不再赘述，
 * 下面是4个人看电影，但是电影院只有2个位置，也就是一次只能2个人在里面看（这里限制不能站着看），有人离开位置，后面的人才可以进来看电影。
 * @Author: Wjh
 * @Date: 2020/9/27 12:24
 * @Modified By:
 */
public class SemaphoreDemo {

    public static final Integer SETS_NUMBER = 2;

    public static final Integer PERSON_NUMBER = 6;

    public static void main(String[] args) {
        Cinema cinema = new Cinema(SETS_NUMBER);

        for (int i = 0; i < PERSON_NUMBER; i++) {
            new Thread(new Person(cinema)).start();
        }
    }
}

class Cinema {
    private Semaphore semaphore;

    public Cinema(int permits) {
        // 总的资源数
        this.semaphore = new Semaphore(permits);
    }

    public void watchMovie() {
        try {
            // 获取到信号量后 执行后续步骤
            semaphore.acquire();
            long time = (long) (Math.random() * 10 + 1);
            System.out.println(Thread.currentThread().getName() + "看了" + time + "秒的电影");
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName() + "让出座位，离开了电影院");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放
            semaphore.release();
        }
    }
}

class Person implements Runnable {

    private Cinema cinema;

    public Person(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.watchMovie();
    }
}
