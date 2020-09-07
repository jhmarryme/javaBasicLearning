package coreJava.functional.runnable;

import org.junit.jupiter.api.Test;

/**
 * description:Runnable接口
 *      它的方法 run() 不带参数，也没有返回值
 *
 * @Author: Wjh
 * @Date: 2020/9/7 11:15
 * @Modified By:
 */
public class RunnableMethodReference {

    @Test
    public void runnableMethodReference() {

        // 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        // lambda表达式
        new Thread(() -> System.out.println("lambda"))
                .start();

        // 方法引用
        new Thread(Go::go).start();
    }
}

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}
