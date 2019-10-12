package javaBase.thread;

/**
 * @author jhmarryme.cn
 * @date 2019/7/14 10:36
 */
public class ThreadSyschronizedFinalTest {

    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Thread th1 = new Thread(tickets, "窗口1");
        Thread th3 = new Thread(tickets, "窗口3");
        Thread th2 = new Thread(tickets, "窗口2");
        th1.start();
        th2.start();
        th3.start();
    }
}
