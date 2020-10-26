package javaBase.functionalProgram.functional.functionalInterface;

import java.util.Comparator;
import java.util.function.*;

/*
 * Description: 将方法引用应用于基于类的函数式接口（即那些不包含基本类型的函数式接口）
 *   创建适合函数式方法签名的最简单的方法
 *
 * @Author: Wjh
 * @Date: 2020/9/8 10:37
 * Modified By:
 */
public class ClassFunctionals {
    // 参数:0  返回:1
    static AA f1() {
        return new AA();
    }
    // 参数:2  返回:1 基本类型
    static int f2(AA aa1, AA aa2) {
        return 1;
    }
    // 参数:1  返回:0
    static void f3(AA aa) {
    }
    // 参数:2  返回:0
    static void f4(AA aa, BB bb) {
    }
    // 参数:1  返回:1 用于Function
    static CC f5(AA aa) {
        return new CC();
    }
    // 参数:2  返回:1 对象 用于BiFunction
    static CC f6(AA aa, BB bb) {
        return new CC();
    }
    // 参数:1  返回: 1 布尔值
    static boolean f7(AA aa) {
        return true;
    }
    // 参数:2  返回: 布尔值
    static boolean f8(AA aa, BB bb) {
        return true;
    }
    // 参数:1  返回: 1 对象
    static AA f9(AA aa) {
        return new AA();
    }
    // 参数:2  返回: 1对象
    static AA f10(AA aa1, AA aa2) {
        return new AA();
    }

    public static void main(String[] args) {
        // 生产一个数据
        Supplier<AA> s = ClassFunctionals::f1;
        s.get();

        // 比较器
        Comparator<AA> c = ClassFunctionals::f2;
        c.compare(new AA(), new AA());

        // 消费一个数据
        Consumer<AA> cons = ClassFunctionals::f3;
        cons.accept(new AA());

        // 消费两个数据
        BiConsumer<AA, BB> bicons = ClassFunctionals::f4;
        bicons.accept(new AA(), new BB());

        // 根据前一个类型的数据得到后一个类型的数据
        Function<AA, CC> f = ClassFunctionals::f5;
        CC cc = f.apply(new AA());

        // 根据前两个类型的数据得到后一个类型的数据
        BiFunction<AA, BB, CC> bif = ClassFunctionals::f6;
        cc = bif.apply(new AA(), new BB());

        // 对该类型的数据进行判断
        Predicate<AA> p = ClassFunctionals::f7;
        boolean result = p.test(new AA());

        // 根据两个类型的数据进行判断
        BiPredicate<AA, BB> bip = ClassFunctionals::f8;
        result = bip.test(new AA(), new BB());

        // 返回值类型与参数类型一致 一个参数
        UnaryOperator<AA> uo = ClassFunctionals::f9;
        AA aa = uo.apply(new AA());

        // 返回值类型与参数类型一致 两个参数
        BinaryOperator<AA> bo = ClassFunctionals::f10;
        aa = bo.apply(new AA(), new AA());
    }
}

class AA {
}

class BB {
}

class CC {
}