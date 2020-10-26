package javaBase.functionalProgram.functional.functionalInterface;

import org.junit.jupiter.api.Test;

import java.util.function.*;

/**
 * description: 基于 Lambda 表达式的所有不同 Function 变体的示例
 *
 * @Author: Wjh
 * @Date: 2020/9/7 17:12
 * @Modified By:
 */
public class FunctionVariants {

    @Test
    public void functionVariants() {

        // 泛型是 参数, 返回值
        Function<Foo, Bar> f1 = foo -> new Bar(foo);
        // 泛型是返回值的类型
        IntFunction<IBaz> f2 = value -> new IBaz(value);
        LongFunction<LBaz> f3 = value -> new LBaz(value);
        DoubleFunction<DBaz> f4 = value -> new DBaz(value);

        // 泛型是参数的类型
        ToIntFunction<IBaz> f5 = value -> value.i;
        ToLongFunction<LBaz> f6 = value -> value.l;
        ToDoubleFunction<DBaz> f7 = value -> value.d;

        // 基本类型转换, 不需要泛型, 某些情况下需要进行强制类型转换
        IntToLongFunction f8 = value -> value;
        IntToDoubleFunction f9 = value -> value;

        LongToIntFunction f10 = value -> (int) value;
        LongToDoubleFunction f11 = value -> value;

        DoubleToIntFunction f12 = value -> (int) value;
        DoubleToLongFunction f13 = value -> (long) value;

        Bar b = f1.apply(new Foo());
        IBaz ib = f2.apply(11);
        LBaz lb = f3.apply(11);
        DBaz db = f4.apply(11);
        int i = f5.applyAsInt(ib);
        long l = f6.applyAsLong(lb);
        double d = f7.applyAsDouble(db);
        l = f8.applyAsLong(12);
        d = f9.applyAsDouble(12);
        i = f10.applyAsInt(12);
        d = f11.applyAsDouble(12);
        i = f12.applyAsInt(13.0);
        l = f13.applyAsLong(13.0);
    }

}

class Foo {

}

class Bar {
    Foo f;

    Bar(Foo f) {
        this.f = f;
    }
}

class IBaz {
    int i;

    IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    long l;

    LBaz(long l) {
        this.l = l;
    }
}

class DBaz {
    double d;

    DBaz(double d) {
        this.d = d;
    }
}
