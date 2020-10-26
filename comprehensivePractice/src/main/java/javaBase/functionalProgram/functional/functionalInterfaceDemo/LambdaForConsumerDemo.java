package javaBase.functionalProgram.functional.functionalInterfaceDemo;

import java.util.function.Consumer;

/**
 * 测试Consumer接口
 * 消费一个指定泛型的数据, 无返回值
 * 可通过andThen组合操作
 * @author jhmarryme.cn
 * @date 2019/7/22 11:21
 */
public class LambdaForConsumerDemo {

    public static void consumerString(String[] info, Consumer<String> con1, Consumer<String> con2, Consumer<String> con3){

        for (String s : info) {
            con1.andThen(con2).andThen(con3).accept(s);
        }

    }

    public static void main(String[] args) {

        String[] array = { "迪丽热巴,女, 14", "古力娜扎,女, 12", "马尔扎哈,男, 121" };

        consumerString(array,
                s -> System.out.print("姓名: " + s.split(",")[0]),
                s -> System.out.print("性别: " + s.split(",")[1]),
                s -> System.out.println("年龄: " + s.split(",")[2])
                );
    }
}
