package concurrentProgramming.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author jhmarryme.cn
 * @date 2019/10/17 13:56
 */
public class CreateThread {

    public static void main(String[] args) {

        new ExtendThread().start();

        new Thread(() -> {
            System.out.println("create thread by implement Runnable");
        }).start();


        // 将Callable包装成FutureTask，FutureTask也是一种Runnable
        final FutureTask<String> futureTask = new FutureTask<>(new ImplCallableThread());
        new Thread(futureTask).start();
        try {
            final String s = futureTask.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ExtendThread extends Thread{
    @Override
    public void run() {
        System.out.println("create thread by extends Thread");
    }
}


class ImplRunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("create thread by implement Runnable");
    }
}

class ImplCallableThread implements Callable<String>{


    @Override
    public String call() throws Exception {
        System.out.println("create thread by implement Callable");

        return "hello";
    }
}
