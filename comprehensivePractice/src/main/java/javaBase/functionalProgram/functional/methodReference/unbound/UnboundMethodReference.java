package javaBase.functionalProgram.functional.methodReference.unbound;

import org.junit.jupiter.api.Test;

/**
 * description: 未绑定的方法引用: 无参数时
 *
 * @Author: Wjh
 * @Date: 2020/9/7 12:05
 * @Modified By:
 */
public class UnboundMethodReference {

    @Test
    public void unboundMethodReference() {
        // 对于非静态的方法, 不能直接引用
        //MakeString ms = X::f;

        // 需要先创建X对象
        X x = new X();
        MakeString f = x::f;
        System.out.println("f.make() = " + f.make());

        // 拿到未绑定的方法引用，并且调用它的transform()方法，将一个X类的对象传递给它
        // 最后使得 x.f() 以某种方式被调用。Java知道它必须拿到第一个参数，该参数实际就是this，然后调用方法作用在它之上。
        TransformX sp = X::f;

        System.out.println("sp.transform(x) = " + sp.transform(x));
    }
}

class X {
    String f() {
        return "X::f()";
    }
}

/*
 * Description: 不能直接接收未绑定的方法引用
 * @Author: Wjh
 * @Date: 2020/9/7 12:25
 * Modified By:
 */
interface MakeString {
    String make();
}

/*
 * Description: 为了解决未绑定的方法引用
 *      需要一个 X 对象作为接口中的一个额外的参数
 *
 * @Author: Wjh 
 * @Date: 2020/9/7 12:23
 * Modified By:
 */
interface TransformX {
    String transform(X x);
}