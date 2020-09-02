package practice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: 字符串相关练习
 *
 * @Author: Wjh
 * @Date: 2020/9/2 10:38
 * @Modified By:
 */
public class StringOperationTestDrive {

    /**
     *  1. 找出所有 长度>=5的字符串，并且忽略大小写、去除重复字符串，然后按字母排序，最后用“爱心❤”连接成一个字符串输出！
     *
     * @Param: []
     * @Return: void
     * @Author: Wjh
     * @Since: 2020/9/2 11:03
     * @Throws 
     **/
    @Test
    public void testPrintWithHeart() {
        String[] list = new String[]{"jhjh", "jhmarryme", "112", "231fff", "12123123", "wjhmarryme", "wjh"};
        // 1. 去除全为数字的串
        // 2. 去除长度小于5的串
        // 3. 去重
        // 4. 转为小写
        // 5. 用❤拼接
        String collect = Arrays.stream(list)
                .filter(s -> !s.matches("[0-9]+"))
                .filter(s -> s.length() > 5)
                .distinct()
                .map(String::toLowerCase)
                .collect(Collectors.joining("❤"));
        System.out.println("collect = " + collect);
    }
}
