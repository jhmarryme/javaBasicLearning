package coreJava.functional.higherOrderFunction;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * description: 产生一个函数
 *
 * @Author: Wjh
 * @Date: 2020/9/8 14:25
 * @Modified By:
 */
public class ProduceFunction {

    // produce() 是高阶函数
    static FunSs produce() {
        // 使用 Lambda 表达式，在方法中创建和返回一个函数
        return s -> s.toLowerCase();
    }

    @Test
    public void produceFunction() {
        FunSs funSs = produce();
        System.out.println("funSs.apply(\"WJH\") = " + funSs.apply("WJH"));
    }
}

//  使用继承，为专用接口创建别名
interface FunSs extends Function<String, String> {

}
