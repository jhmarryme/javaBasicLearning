package dataType;

/**
 * @author jhmarryme.cn
 * @date 2019/6/21 10:11
 */
public class IntegerCacheStudy {
    public static void main(String[] args) {
        /*Integer x = new Integer(123);
        Integer y = new Integer(123);
        System.out.println(x == y);    // false
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);
        System.out.println(z == k);   // true*/
       /* Integer m = 111;
        Integer n = 111;
        System.out.println(m == n);*/

/*
       String str1 = new String("hello world");
       String str2 = new String("hello world");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
*/
        /*String str1 = "hello world";
        String intern = str1.intern();
        System.out.println(intern);*/
        String str1 = new String ("wjh");
        String str2 = new String(str1);
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        double d = 1;
        float f = 1;
        short s = 1;
        s += 1;

        SuperExample e = new SuperExtendExample(1, 2, 3);
        e.func2();
    }
}
