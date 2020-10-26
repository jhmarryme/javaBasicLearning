package javaBase.functionalProgram.functional.functionalInterface.missingBasicTypes;

import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

/**
 * description: 缺少基本类型的函数, 简单使用了包装类型，装箱和拆箱负责它与基本类型之间的来回转换
 *
 * @Author: Wjh
 * @Date: 2020/9/8 14:17
 * @Modified By:
 */
public class BiConsumerPermutations {

    // 创建缺少的针对 int，long 和 double 的各种排列
    static BiConsumer<Integer, Double> bicid = (i, d) ->
            System.out.format("%d, %f%n", i, d);
    static BiConsumer<Double, Integer> bicdi = (d, i) ->
            System.out.format("%d, %f%n", i, d);
    static BiConsumer<Integer, Long> bicil = (i, l) ->
            System.out.format("%d, %d%n", i, l);

    @Test
    public void biConsumerPermutations() {
        bicid.accept(1, 1.1);
        bicdi.accept(1.1, 1);
        bicil.accept(1, 1L);
    }
}
