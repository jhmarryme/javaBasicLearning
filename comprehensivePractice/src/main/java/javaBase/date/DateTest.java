package javaBase.date;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/8/26 15:00
 * @Modified By:
 */
public class DateTest {

    @Test
    @DisplayName("date基本用法")
    public void useDate() {
        // 获取当前时间:
        Date date = new Date();
        // 必须加上1900
        System.out.println(date.getYear() + 1900);
        // 0~11，必须加上1
        System.out.println(date.getMonth() + 1);
        // 1~31，不能加1
        System.out.println(date.getDate());
        // 转换为String:
        System.out.println(date.toString());
        // 转换为GMT时区:
        System.out.println(date.toGMTString());
        // 转换为本地时区:
        System.out.println(date.toLocaleString());
    }

    @SneakyThrows
    @Test
    @DisplayName("date的处理")
    public void handleDate() {
        // 获取当前时间:
        Date date = new Date();

        // 1. 使用自定义格式将date格式化为字符串
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));

        // 2. 使用预定义格式将date格式化为字符串
        // M：输出9
        // MM：输出09
        // MMM：输出Sep / 9月
        // MMMM：输出September / 九月
        sdf = new SimpleDateFormat("E MMMM dd, yyyy");
        System.out.println(sdf.format(date));

        // 将字符串格式化为date
        Date parse = sdf.parse("2021-06-18 12:00:12");
        System.out.println(parse);

    }
}
