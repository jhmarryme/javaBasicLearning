package coreJava.functional.functionalInterface.multiParameter;

import org.junit.jupiter.api.Test;

/**
 * description: 多参数函数式接口
 *
 * @Author: Wjh
 * @Date: 2020/9/8 11:26
 * @Modified By:
 */
public class TriFunctionTest {

    static int f(int i, long l, double d) {
        return 100;
    }

    @Test
    public void triFunction() {
        // lambda表达式
        TriFunction<Integer, Long, Double, Integer> triFunction = (integer, aDouble, aLong) -> 10;
        // 方法引用
        triFunction = TriFunctionTest::f;
        System.out.println("triFunction.apply(1, 1l, 1.0) = " + triFunction.apply(1, 1l, 1.0));
    }
}
