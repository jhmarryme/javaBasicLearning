package coreJava.lambda.onjava8.recursive.factorial;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/4 9:03
 * @Modified By:
 */
public class RecursiveFactorial {

    static IntCall fact;

    @Test
    public void factorial() {
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);
        IntStream.iterate(0, value -> value < 10, operand -> operand + 1)
                .forEach(value -> {
                    System.out.println("fact.call(value) = " + fact.call(value));
                });
    }
}
