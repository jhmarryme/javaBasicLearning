package javaBase.date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * ZonedDateTime
 *
 * <p>可以简单地把ZonedDateTime理解成LocalDateTime加ZoneId。ZoneId是java.time引入的新的时区类，注意和旧的java.util.TimeZone区别。
 * @author JiaHao Wang
 * @date 2021/6/18 15:46
 */
public class ZonedDateTimeTest {

    /**
     * 创建一个ZonedDateTime对象
     */
    @Test
    @DisplayName("创建一个ZonedDateTime对象")
    public void whenCreateZonedDateTimeSuccess() {
        // 默认时区
        ZonedDateTime zbj = ZonedDateTime.now();
        // 用指定时区获取当前时间
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));

        // 打印的两个ZonedDateTime，它们时区不同，但表示的时间都是同一时刻（毫秒数不同是执行语句时的时间差）：
        System.out.println(zbj);
        System.out.println(zny);
    }

    /**
     * LocalDateTime -> ZonedDateTime
     *
     * <p>通过给一个LocalDateTime附加一个ZoneId，就可以变成ZonedDateTime
     * <p>要特别注意，时区转换的时候，由于夏令时的存在，不同的日期转换的结果很可能是不同的
     * <p>涉及到时区时，千万不要自己计算时差，否则难以正确处理夏令时。
     * @author Jiahao Wang
     * @date 2021/6/18 15:47
     */

    @Test
    @DisplayName("LocalDateTime <-> ZonedDateTime")
    public void whenSuccess() {
        LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
        // ZoneId.getAvailableZoneIds()可以获取可用的时区信息
        ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zny = ldt.atZone(ZoneId.of("America/New_York"));

        // 以这种方式创建的ZonedDateTime，它的日期和时间与LocalDateTime相同，但附加的时区不同，因此是两个不同的时刻：
        System.out.println(zbj);
        System.out.println(zny);

        // 转换为LocalDateTime时，直接丢弃了时区信息。
        LocalDateTime localDateTime = zbj.toLocalDateTime();
        System.out.println(localDateTime);
    }

    /**
     * 时区转换
     */
    @Test
    @DisplayName("时区转换")
    public void whenTimeZoneConversionSuccess() {

        // 以中国时区获取当前时间:
        ZonedDateTime zbj = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        // 转换为纽约时间:
        ZonedDateTime zny = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);
    }
}
