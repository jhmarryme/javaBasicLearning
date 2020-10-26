package javaBase.functionalProgram.functional.functionalInterfaceDemo;

import java.util.Arrays;

/**
 * 通过lambda表达式 作为比较器
 * @author jhmarryme.cn
 * @date 2019/7/22 9:43
 */
public class LambdaForComparatorDemo {

    public static void main(String[] args) {
        String[] array = { "abc", "ab", "abcd" };
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, (a, b) -> {
        return a.length() - b.length();
    });
        System.out.println(Arrays.toString(array));

    }
}
