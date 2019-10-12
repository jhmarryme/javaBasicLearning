package javaBase.functionalInterface.functionalInterfaceDemo;

import java.util.function.Supplier;

/**
 * 测试Supplier接口
 * 包含一个无参的方法, 用来获取一个泛型参数指定类型的对象数据
 * @author jhmarryme.cn
 * @date 2019/7/22 9:52
 */
public class LambdaForSupplierDemo {

    public static void main(String[] args) {
        /*String msgA = "Hello";
        String msgB = "World";

        System.out.println(getString(() -> msgA + msgB));*/

        int arr[] = {2,3,4,52,333,23};

        System.out.println(getMax(() -> {

            int max = arr[0];
            for (int i : arr) {
                max = i > max ? i : max;
            }
            return max;
        }));
    }


    public static int getMax(Supplier<Integer> integerSupplier){
        return integerSupplier.get();
    }



    public static String getString(Supplier<String> stringSupplier){
        return stringSupplier.get();
    }



}
