package javaBase.thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jhmarryme.cn
 * @date 2019/7/17 11:06
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        RunnableForPool r = new RunnableForPool();

        service.submit(r);
        service.submit(r);
        service.submit(r);


    }
}
