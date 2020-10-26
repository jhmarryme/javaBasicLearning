package javaBase.functionalProgram.functional.functionalInterface.missingBasicTypes;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * description: 将包装类型和Function
 *
 * @Author: Wjh
 * @Date: 2020/9/8 14:20
 * @Modified By:
 */
public class FunctionWithWrapped {

    @Test
    public void functionWithWrapped() {
        // 如果没有强制转换，则会收到错误消息：“Integer cannot be converted to Double”（Integer 无法转换为 Double）
        Function<Integer, Double> fid = integer -> (double)integer;
        // 使用 IntToDoubleFunction 就没有此类问题
        IntToDoubleFunction fid2 = i -> i;
    }
}
