package javaBase.functionalProgram.functional.functionalInterfaceDemo;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * 通过函数式接口练习predicate相关的方法
 * 对泛型指定数据类型进行判断, 得到一个布尔值.
 * 包含与或非and, or, negate
 * @author jhmarryme.cn
 * @date 2019/7/22 12:54
 */
public class LambdaForPredicateDemo {

    public static Boolean method( Predicate<String> stringPredicate){
        return stringPredicate.test("helloWorld");
    }

    public static void method(Predicate<String> p1, Predicate<String> p2){

        final boolean helloWorld = p1.or(p2).test("HelloWorld");
        System.out.println(helloWorld);

    }



    public static ArrayList<String> filterString(String[] arr, Predicate<String> stringPredicate){

        final ArrayList<String> list = new ArrayList<>();

        for (String s : arr) {
            if (stringPredicate.test(s)) {
                list.add(s);
            }
        }
        return list;
    }



    public static void main(String[] args) {

        /*System.out.println(method(s -> {
            return s.length() > 5;
        }));
*/

//        method(s -> s.contains("el"), s -> s.length() > 10);



        /**
         * 筛选条件:
         * 必须为女生；
         * 姓名为4个字。
         */
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };
        final ArrayList<String> arrayList = filterString(array, s -> {

            return s.split(",")[1].equals("女") && s.split(",")[0].length() == 4;

        });
        for (String s : arrayList) {
            System.out.println(s);
        }


    }
}
