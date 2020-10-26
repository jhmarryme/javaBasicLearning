package javaBase.functionalProgram.functional.methodReference.unbound;

import org.junit.jupiter.api.Test;

/**
 * description: 未绑定的方法引用: 多个参数时
 *
 * @Author: Wjh
 * @Date: 2020/9/7 12:27
 * @Modified By:
 */
public class MultiUnbound {

    @Test
    public void multiUnbound() {
        // 先创建一个对象的引用
        This aThis = new This();

        TwoArgs two = This::two;
        ThreeArgs three = This::three;
        FourArgs four =This::four;

        two.call2(aThis, 520, 520.0);
        three.call3(aThis, 521, 521.1, "three");
        four.call4(aThis, 522, 522.2, "four", 'f');
    }
}

class This {
    void two(int i, double d) {
        System.out.println("two");
    }

    void three(int i, double d, String s) {
        System.out.println("three");
    }

    void four(int i, double d, String s, char c) {
        System.out.println("four");
    }
}

/*
 * Description: 需要传入一个调用的对象, 这里是This类型
 * @Author: Wjh
 * @Date: 2020/9/7 14:05
 * Modified By:
 */
interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(
            This athis, int i, double d, String s, char c);
}
