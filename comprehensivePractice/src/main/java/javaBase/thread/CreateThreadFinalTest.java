package javaBase.thread;

/**
 * @author jhmarryme.cn
 * @date 2019/7/14 9:55
 */
public class CreateThreadFinalTest {
    public static void main(String[] args) {

        /*Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("thread1 -> i = " + i);
                }
            }
        });*/
        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("thread1 -> i = " + i);
            }
        });
        th1.start();
        Thread2 th2 = new Thread2("thread2");
        th2.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main  thread -> i = " + i);
        }
    }

}

class Thread2 extends Thread{

    public Thread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("thread2 -> i = " + i);
        }
    }
}
