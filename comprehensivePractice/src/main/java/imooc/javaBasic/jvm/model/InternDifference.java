package imooc.javaBasic.jvm.model;

/**
 *
 * 比较JDK1.6 与之后版本String的intern方法的区别
 * @author jhmarryme.cn
 * @date 2019/9/12 13:17
 */
public class InternDifference {

    // 1.7之后的版本
    public static void main(String[] args) {
        // 首先将 a 放入常量池中, new String时,. 会在堆区也放入a
        String str1 = new String("a");
        // 此时将堆区中的a试图放入常量池, 发现已经有了a 所以失败了.
        str1.intern();
        String str2 = "a";
        // 这里比较的其实是堆区中的a 与 常量池中的a
        System.out.println(str1 == str2);

        //newString时放入堆区的是aa   而在常量池中的是a
        String str3 = new String("a") + new String("a");
        // 在1.6的版本中, 如果常量池中已经存在, 则返回该引用, 如果不存在则将字符串对象添加到常量池并返回引用
        // 区别于1.7之前的版本, 首先判断常量池中有没有该字符串, 发现没有, 再看java堆中是否存在
        // 如果存在, 则将字符串对象的引用放入常量池, 并返回该引用.
        // 如果不存在 则创建字符串对象并返回引用
        str3.intern();
        String str4 = "aa";
        // 如果是1.6版本则为false, 因为一个是堆区的对象, 一个是常量池
        // 1.7以后则为true
        System.out.println(str3 == str4);
    }
}
