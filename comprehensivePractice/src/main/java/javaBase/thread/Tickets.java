package javaBase.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jhmarryme.cn
 * @date 2019/7/14 10:37
 */
class Tickets implements Runnable{

    private int tickets = 100;

    //同步锁对象 任类型
    Object object = new Object();

    Lock lock = new ReentrantLock();
    @Override
    public void run() {

        while(true){
            /*synchronized (object){
                if (tickets>0) {
                    //模拟出票时间

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    System.out.println(Thread.currentThread().getName() + "正在卖第" + (tickets--) + "张票");
                }
            }*/


            lock.lock();
            if (tickets>0) {
                //模拟出票时间

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println(Thread.currentThread().getName() + "正在卖第" + (tickets--) + "张票");
            }
            lock.unlock();

//            saleTickets();
        }

    }

    private synchronized void saleTickets() {
        if (tickets>0) {
            //模拟出票时间

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(Thread.currentThread().getName() + "正在卖第" + (tickets--) + "张票");
        }
    }
}
