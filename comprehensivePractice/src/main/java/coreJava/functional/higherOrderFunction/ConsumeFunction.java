package coreJava.functional.higherOrderFunction;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * description: 消费一个函数
 *
 * @Author: Wjh
 * @Date: 2020/9/9 14:50
 * @Modified By:
 */
public class ConsumeFunction {
    static Two consume(Function<One, Two> oneTwoFunction) {
        One one = new One();
        return oneTwoFunction.apply(one);
    }

    @Test
    public void consumeFunction() {
        Two two = consume(one -> new Two());
    }
}

class One {}

class Two {}
