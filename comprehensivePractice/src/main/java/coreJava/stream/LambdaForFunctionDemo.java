package coreJava.stream;

import java.util.function.Function;

public class LambdaForFunctionDemo {


    /**
     * 根据接口的泛型
     * apply方法中参数类型为String, 返回Integer
     * @param integerFunction
     */
    public static void method(Function<String, Integer> integerFunction){

        final Integer apply = integerFunction.apply("5");
        System.out.println(apply + 20);
    }


    /**
     * 在前一个function的基础上再进行处理
     * 第二个function的第一个泛型必须为前一个function的后一个泛型
     * 相当于前一个的结果为Integer, 后一个就必须用Integer接收
     * @param f1
     * @param f2
     */
    public static void methood(Function<String, Integer> f1, Function<Integer, Integer> f2){

        final Integer apply = f1.andThen(f2).apply("1");
        System.out.println(apply);
    }

    /**
     * 截取数字部分, 得到的结果加上100返回
     * @param str
     * @param f1
     * @param f2
     * @return
     */
    public static Integer getAgeNum(String str, Function<String, Integer> f1, Function<Integer, Integer> f2){
        return f1.andThen(f2).apply(str);
    }


    public static void main(String[] args) {
        method(Integer::parseInt);

        methood(s -> Integer.parseInt(s)+1, i -> i = ((int)Math.pow(i, 10)));
        String str = "赵丽颖,20";
        final Integer ageNum = getAgeNum(str,
                s -> Integer.parseInt(s.split(",")[1]),
                i -> i = i + 100
        );

        System.out.println(ageNum);
    }
}