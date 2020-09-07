package coreJava.functional.methodReference.common;

/**
 * description: 方法引用
 *
 * 1. `object::instanceMethod`
 *
 *    `System.out::println` 等价于` x -> System.out.println(x)`
 *
 * 2. `Class::instanceMethod`
 *
 *    `String::compareToIgnoreCase` 等同于` (x, y) -> x.compareToIgnoreCase(y)`
 *
 *    第一个参数会成为方法的隐式参数. 可以只有一个参数
 *
 * 3. `Class::staticMethod`
 *
 *    `Math::pow` 等价于 `(x，y) ->Math.pow(x, y)`
 *
 *    可以只有一个参数
 *
 * 4. `super::instanceMethod` / `this::instanceMethod`
 *
 *    `this::equals` 等同于 `x -> this.equals(x)`
 *
 * 5. 构造器引用 `Person::new `
 *
 *    使用的具体构造器取决于上下文.
 *
 *    `int[]::new` 是一个构造器引用，它有一个参数：即数组的长度。这等价于 lambda 表达式 x -> new int[x]
 *
 *    `Integer::new` 等同于 `x -> new Integer(x)`
 *
 * @Author: Wjh
 * @Date: 2020/9/7 10:58
 * @Modified By:
 */
public class MethodReferences {

    static void hello(String name) {
        System.out.println("hello: " + name);
    }

    static class Description {
        String about;

        public Description(String about) {
            this.about = about;
        }

        void help(String msg) {
            System.out.println(about + " " + msg);
        }
    }

    static class Helper {
        static void assist(String msg) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe describe = new Describe();
        // 普通类的普通方法
        Callable show = describe::show;

        // 普通类的静态方法
        Callable hello = MethodReferences::hello;

        // 静态类的普通方法
        Callable valuable = new Description("valuable")::help;

        // 静态类的静态方法
        Callable assist = Helper::assist;

        show.call("show");
        hello.call("hello");
        valuable.call("valuable");
        assist.call("assist");
    }
}

interface Callable {
    void call(String s);
}

class Describe {
    void show(String msg) {
        System.out.println(msg);
    }
}