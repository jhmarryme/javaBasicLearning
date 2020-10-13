package effectiveJava._6_notnecessaryobject;

import java.util.regex.Pattern;

/**
 * description: 6. 避免创建不必要的对象
 *
 * @Author: Wjh
 * @Date: 2020/8/26 10:42
 * @Modified By:
 */
public class RomanNumerals {

    // 将Pattern显式编译为一个不可变的实例 作为缓存
    // 正则 有效的罗马数字
    public static final Pattern ROMAN= Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }

    /**
     * description:  进行了不必要的自动装箱会严重影响性能
     * @Param: []
     * @Return: void
     * @Author: Wjh
     * @Date: 2020/8/26 10:58
     * @Throws
     */
    public static void sumWithAutoBoxing() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

    public static void sumWithoutAutoBoxing() {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}
