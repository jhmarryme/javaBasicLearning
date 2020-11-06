package reading.guava.handlestring;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * description: 字符串处理：分割，连接，填充
 *      https://wizardforcel.gitbooks.io/guava-tutorial/content/23.html
 *      http://www.ibloger.net/article/3336.html
 * @Author: Wjh
 * @Date: 2020/11/3 9:57
 * @Modified By:
 */
public class HandleStringTest {

    /**
     *  joiner实例总是不可变的。用来定义joiner目标语义的配置方法总会返回一个新的joiner实例。
     *  这使得joiner实例都是线程安全的，你可以将其定义为static final常量。
     *
     * @Param: []
     * @Return: void
     * @Author: Wjh
     * @Since: 2020/11/4 9:38
     * @Throws
     **/
    @Test
    public void whenUseJoinerSuccess() {
        // 忽略null对象
        String skipNullStr = Joiner.on(",").skipNulls().join(Arrays.asList("Harry", null, "Ron", "Hermione"));
        System.out.println("skipNullStr = " + skipNullStr);

        // 以给定某个字符串来替换null
        String insteadOfNullStr = Joiner.on(",").useForNull("null").join(Arrays.asList("Harry", null, "Ron", "Hermione"));
        System.out.println("insteadOfNullStr = " + insteadOfNullStr);
    }


    /**
     *  拆分器
     *
     * @Param: []
     * @Return: void
     * @Author: Wjh
     * @Since: 2020/11/4 10:33
     * @Throws 
     **/
    @Test
    public void whenUseSplitterSuccess() {
        // 有尾部的空字符串被忽略了, [, a, , b]
        System.out.println("Arrays.toString(\",a,,b,\".split(\",\")) = " + Arrays.toString(",a,,b,".split(",")));

        // a, b
        Iterable<String> split = Splitter.on(",").trimResults().omitEmptyStrings().split(",a,,b,");
        split.forEach(System.out::println);
    }

    /**
     *  字符串的 修剪[trim]、折叠[collapse]、移除[remove]、保留[retain]等等
     *
     * @Param: []
     * @Return: void
     * @Author: Wjh
     * @Since: 2020/11/4 10:33
     * @Throws
     **/
    @Test
    public void whenUseCharMatcher() {
        String str = "    09991   0String   3asd*   77)()&y%   4%*^'';.,   ";
        System.out.println("str = " + str);
        CharMatcher digitCharMatcher = CharMatcher.inRange('0', '9');

        // 移除数字字符
        String removeDigitFrom = digitCharMatcher.removeFrom(str);
        System.out.println("removeDigitFrom = " + removeDigitFrom);

        // 只保留数字字符
        String retainDigitFrom = digitCharMatcher.retainFrom(str);
        System.out.println("retainDigitFrom = " + retainDigitFrom);

        // whitespace匹配空白字符,
        // trimAndCollapseFrom: (collapseFrom / trimFrom)
        //      (移除字符序列的前导匹配字符和尾部匹配字符 / 把每组连续的匹配字符替换为特定字符)
        // 去除两端的空格，并把中间的连续空格替换成-
        String trimAndCollapseFrom = CharMatcher.whitespace().trimAndCollapseFrom(str, '-');
        System.out.println("trimAndCollapseFrom = " + trimAndCollapseFrom);

        // 将 'aeiou' 中的任一字符替换为-
        String aeiou = CharMatcher.anyOf("aeiou").replaceFrom(str, '-');
        System.out.println("aeiou = " + aeiou);

        // 将 空格或\ 替换为?
        String replaceFrom = CharMatcher.is(' ').or(CharMatcher.is('\'')).replaceFrom(str, '?');
        System.out.println("replaceFrom = " + replaceFrom);

        // 将 小写字符 替换为?, CharMatcher.javaLowerCase()的替代实现方法
        String replace = CharMatcher.forPredicate(Character::isLowerCase).replaceFrom(str, '?');
        System.out.println("replace = " + replace);
    }
}
