package javaBase.functionalProgram.functional.DelayForLambda;

import static javaBase.functionalProgram.functional.DelayForLambda.MessageBuilder.MAX_NUM;

/**
 * 测试lambda表达式的延迟执行
 * 优化性能, 在不符合条件时, 不会执行lambda的内容
 * @author jhmarryme.cn
 * @date 2019/7/22 9:32
 */
public class DelayForLambdaDemo {

    public static void log(int level, MessageBuilder builder){
        if (level == 1) {
            System.out.println(builder.messageBuilder());
        }
    }


    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        String msgC = "Java";
        //这里的拼接字符串 在条件不成立时不会执行
        log(1, () -> msgA + msgB + msgC );
    }
}
