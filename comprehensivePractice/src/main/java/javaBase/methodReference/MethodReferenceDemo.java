package javaBase.methodReference;

/**
 * @author jhmarryme.cn
 * @date 2019/7/24 13:44
 */
public class MethodReferenceDemo {


    public static void printStr(TestInterface testInterface){
        testInterface.printStr("helloword");
    }


    private static void method(int num, Calcable lambda) {
        System.out.println(lambda.calc(num));
    }



    public static void main(String[] args) {

//        通过对象名引用成员方法
//        printStr(new MethodRefObject()::printUpperCase);

//        通过类名称引用静态方法
        method(-10, Math::abs);
//        通过super引用成员方法

//        通过this引用成员方法

//        类的构造器引用

//        数组的构造器引用

    }
}
