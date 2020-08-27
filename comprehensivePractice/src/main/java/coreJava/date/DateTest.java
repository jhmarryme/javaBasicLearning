package coreJava.date;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/8/26 15:00
 * @Modified By:
 */
public class DateTest {
    /*
     * description: 日期简单格式化操作
     * @Author: Wjh
     * @Date: 2020/8/27 9:28
     */
    @Test
    public void test() {
        // 打印当前时间
        System.out.println("LocalTime.now() = " + LocalTime.now());
        // 打印当前日期
        System.out.println("LocalDate.now() = " + LocalDate.now());
        // 将当前时间格式化后打印
        System.out.println("LocalDateTime.now().format(DateTimeFormatter.ofPattern(\"yyyy:MM:dd:HH:mm:ss\")) = "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss")));

        // 字符串 -> LocalTime
        LocalTime parse = LocalTime.parse("13:00", DateTimeFormatter.ISO_TIME);

        // 格式化当前日期
        System.out.println("LocalTime.now().format(DateTimeFormatter.ISO_TIME) = "
                + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        // 将localDate和localTime 组合为localDateTime
        LocalDateTime of = LocalDateTime.of(date, time);
        System.out.println("of.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) = " + of.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("of.format(DateTimeFormatter.ISO_DATE_TIME) = " + of.format(DateTimeFormatter.ISO_DATE_TIME));
        // 格式化输出
        System.out.println("of.format(DateTimeFormatter.ofPattern(\"yyyy:MM:dd\")) = " + of.format(DateTimeFormatter.ofPattern("yyyy:MM:dd")));

        // hh 12小时制, HH 24小时制
        System.out.println("LocalDateTime.parse(\"2019:08:29:14:22:01\", DateTimeFormatter.ofPattern(\"yyyy:MM:dd:HH:mm:ss\")) = "
                + LocalDateTime.parse("2019:08:29:14:22:01", DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss")));
    }

    /*
     * description: 计算时间差
     * @Author: Wjh
     * @Date: 2020/8/27 9:28
     */
    @Test
    public void test2() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now1 = LocalDateTime.now();
        LocalDateTime time = now.minusDays(2);

        Duration between = Duration.between(time, now1);
        System.out.println("between.toDays() = " + between.toDays());
        System.out.println("between.toHours() = " + between.toHours());
        System.out.println("between.toMinutes() = " + between.toMinutes());
    }
}
