package coreJava.lambda.onjava8.recursive.fibonacci;

import coreJava.lambda.onjava8.recursive.factorial.IntCall;
import org.junit.jupiter.api.Test;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/7 9:33
 * @Modified By:
 */
public class RecursiveFibonacci {
    IntCall fib;

    @Test
    public void fibonacci() {
        // Fibonacci 序列用递归的 Lambda 表达式来实现
        fib = n -> n == 0 ? 0 : n == 1 ? 1 : fib.call(n - 1) + fib.call(n - 2);

        for (int i = 0; i <= 10; i++) {
            System.out.println("fib.call(i) = " + fib.call(i));
        }
    }
}
