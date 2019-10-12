package javaBase.thread;

/**
 * @author jhmarryme.cn
 * @date 2019/7/4 19:55
 */
public class ThreadTest {

    private static final ThreadLocal<Long> STRING_THREAD_LOCAL = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return 0L;
        }
    };

    public static void main(String[] args) {
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();*/
//        new MyThread("test").start();
        Runnable r = new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 20; i++) {
                    System.out.println("张宇:"+i);
                }
            }
        };
        new Thread(r).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("费玉清:"+i);
        }
    }

    }




