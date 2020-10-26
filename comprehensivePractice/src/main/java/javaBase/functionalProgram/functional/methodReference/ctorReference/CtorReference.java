package javaBase.functionalProgram.functional.methodReference.ctorReference;

import org.junit.jupiter.api.Test;

/**
 * description: 构造函数引用
 *
 * @Author: Wjh
 * @Date: 2020/9/7 14:08
 * @Modified By:
 */
public class CtorReference {

    @Test
    public void ctorReference() {
        MakeNoArgs noArgs = Dog::new;
        MakeOneArg oneArg = Dog::new;
        MakeTwoArgs twoArgs = Dog::new;

        Dog dn = noArgs.make();

        Dog d1 = oneArg.make("wjh");

        Dog d2 = twoArgs.make("wjh", 24);

    }

}

interface MakeNoArgs {
    Dog make();
}

interface MakeOneArg {
    Dog make(String name);
}

interface MakeTwoArgs {
    Dog make(String name, int age);
}

class Dog {
    String name;
    int age = -1; // For "unknown"

    Dog() {
        name = "stray";
    }

    Dog(String nm) {
        name = nm;
    }

    Dog(String nm, int yrs) {
        name = nm;
        age = yrs;
    }
}
