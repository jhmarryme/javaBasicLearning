package javaBase.thread.ThreadPool;

/**
 * @author jhmarryme.cn
 * @date 2019/7/17 11:05
 */
public class RunnableForPool implements Runnable{
    @Override
    public void run() {
        System.out.println("线程准备");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : 正在使用");
        System.out.println(Thread.currentThread().getName() + "使用完毕");
    }
}
