package concurrentProgramming.basic;


/**
 * @author jhmarryme.cn
 * @date 2019/10/17 15:16
 */
public class ThreadInterruptTest {
    int i;
    public static void main(String[] args) {

        Thread threadOne = new Thread(() -> {
            for (; ; ) {

            }
        });

        threadOne.start();
        threadOne.interrupt();
        System.out.println(threadOne.isInterrupted());

        System.out.println(Thread.interrupted());
        System.out.println(threadOne.isInterrupted());

    }
}
