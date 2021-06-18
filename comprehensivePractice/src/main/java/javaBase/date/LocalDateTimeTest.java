package javaBase.date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * LocalDateTime 不承载时区信息，因此，其不能与 Instant 相互转换，必须提供时区信息。
 * @author JiaHao Wang
 * @date 2021/6/18 11:38
 */
public class LocalDateTimeTest {

    /**
     * 严格按照ISO 8601格式打印
     * <pre>
     *      {@code 
     *      2021-06-18
     *      14:09:41.034987500
     *      2021-06-18T14:09:41.034987500}
     * </pre>
     */
    @Test
    @DisplayName("严格按照ISO 8601格式打印")
    public void whenPrintSuccess() {
        // 当前日期
        LocalDate d = LocalDate.now();
        // 当前时间
        LocalTime t = LocalTime.now();
        // 当前日期和时间
        LocalDateTime dt = LocalDateTime.now();
        // 严格按照ISO 8601格式打印
        System.out.println(d);
        System.out.println(t);
        System.out.println(dt);
    }

    /**
     * 使用.of()创建Local Time/Date/DateTime
     */
    @Test
    @DisplayName("使用.of()创建Local Time/Date/DateTime")
    public void whenUseOfCreateTimeSuccess() {
        // 指定日期和时间:
        // 2019-11-30
        LocalDate d2 = LocalDate.of(2019, 11, 30);
        // 15:16:17
        LocalTime t2 = LocalTime.of(15, 16, 17);
        // 2019-11-30 15:16:17
        LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);

        // 组合LocalDate和LocalTime
        LocalDateTime dt3 = LocalDateTime.of(d2, t2);
    }

    /**
     * 使用.format() 将日期转为字符串
     */
    @Test
    @DisplayName("使用.format() 将日期转为字符串")
    public void whenFormatDateSuccess() {
        // 1. LocalTime
        // 1.1 标准 14:18:54.8330878
        String timeFormat1 = LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println("标准timeFormat1 = " + timeFormat1);


        // 1.2 自定义格式 14:18:54
        String timeFormat2 = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("自定义格式timeFormat2 = " + timeFormat2);

        // 2. LocalDate
        // 2.1 标准
        String dateFormat1 = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("标准dateFormat1 = " + dateFormat1);

        // 2.2 自定义格式
        String dateFormat2 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("自定义格式dateFormat2 = " + dateFormat2);

        // 3. LocalDateTime
        // 3.1 标准
        String dateTimeFormat1 = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println("标准dateTimeFormat1 = " + dateTimeFormat1);

        // 3.2 自定义格式
        String dateTimeFormat2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("自定义格式dateTimeFormat2 = " + dateTimeFormat2);
    }


    /**
     * ISO 8601规定的日期和时间分隔符是T。标准格式如下：
     *
     * <ul>
     *     <li>>日期：yyyy-MM-dd
     *     <li>>时间：HH:mm:ss
     *     <li>>带毫秒的时间：HH:mm:ss.SSS
     *     <li>>日期和时间：yyyy-MM-dd'T'HH:mm:ss
     *     <li>>带毫秒的日期和时间：yyyy-MM-dd'T'HH:mm:ss.SSS
     * </ul>
     */
    @Test
    @DisplayName("使用.parse()格式ISO 8601标准的时间串")
    public void whenUseParseFormatTimeSuccess() {
        LocalDateTime dt1 = LocalDateTime.parse("2019-11-19T15:16:17");
        LocalDateTime dt2 = LocalDateTime.parse("2021-06-18T14:04:59.961111200");
        LocalDate d = LocalDate.parse("2019-11-19");
        LocalTime t = LocalTime.parse("15:16:17");
        LocalTime t2 = LocalTime.parse("15:16:17.961111200");
    }

    /**
     * 使用.parse() 将字符串 -> 日期
     */
    @Test
    @DisplayName("使用.parse() 将字符串 -> 日期")
    public void whenUseParseSuccess() {
        // 1. LocalTime
        // 都可以成功格式化
        // 不带秒
        LocalTime timeWithoutSeconds = LocalTime.parse("13:00", DateTimeFormatter.ISO_TIME);
        // 带上秒
        LocalTime timeWithSeconds = LocalTime.parse("10:15:30", DateTimeFormatter.ISO_TIME);
        LocalTime timeWithZone = LocalTime.parse("10:15:30+01:00", DateTimeFormatter.ISO_TIME);

        // 2. LocalDate

        // 3. LocalDateTIme
        // 都是类似的

    }

    /**
     * 判断时间的方法
     * <pre>
     *     <li>isAfter()：判断一个日期是否在指定日期之后
     *     <li>isBefore()：判断一个日期是否在指定日期之前
     *     <li>isEqual()：判断两个日期是否相同
     *     <li>isLeapYear()：判断是否是闰年（注意是LocalDate类 和 LocalDateTime类特有的方法）
     * </pre>
     */
    @Test
    @DisplayName("判断时间的方法")
    public void whenDetermineTimeSuccess() {
        //获取当前的日期
        LocalDate now = LocalDateTime.now().toLocalDate();

        //指定的日期
        LocalDate of = LocalDate.of(2015, 12, 12);

        //判断一个日期是否在另一个日期之前
        boolean before = of.isBefore(now);
        System.out.println(before);

        //判断一个日期是否在另一个日期之后
        boolean after = of.isAfter(now);
        System.out.println(after);

        //判断这两个日期是否相等
        boolean after1 = now.equals(of);
        System.out.println(after1);

        //判断闰年
        boolean leapYear = of.isLeapYear();
        System.out.println(leapYear);
    }

    /**
     * 使用.with() 简单的调整日期
     */
    @Test
    @DisplayName("使用.with() 简单的调整日期")
    public void whenUseWithAdjustTimeSuccess() {
        LocalDateTime dt = LocalDateTime.of(2019, 10, 26, 20, 30, 59);
        System.out.println(dt);
        // 日期变为31日:
        LocalDateTime dt2 = dt.withDayOfMonth(31);
        // 2019-10-31T20:30:59
        System.out.println(dt2);
        // 月份变为9:
        LocalDateTime dt3 = dt2.withMonth(9);
        // 2019-09-30T20:30:59
        System.out.println(dt3);
    }

    /**
     * 使用.with() 更复杂的调整日期
     */
    @Test
    @DisplayName("使用.with() 更复杂的调整日期")
    public void whenUseWithComplexAdjustTimeSuccess() {
        // 本月第一天0:00时刻:
        LocalDateTime firstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay();
        System.out.println(firstDay);

        // 本月最后1天:
        LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDay);

        // 下月第1天:
        LocalDate nextMonthFirstDay = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(nextMonthFirstDay);

        // 本月第1个周一:
        LocalDate firstWeekday = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        System.out.println(firstWeekday);

        // 获取这个月的第x个星期x是的日期,比如 TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY)
        // 代表这个月第二个星期五的日期
        LocalDate with2 = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY));
        System.out.println(with2);

        //自定义日期 - 下一个工作日
        LocalDate nextWorkingDay = LocalDate.now().with(new TemporalAdjuster() {
            @Override
            // 参数 nowDate 当前的日期对象
            public Temporal adjustInto(Temporal nowDate) {
                // 向下转型
                LocalDate date = (LocalDate) nowDate;
                if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    return date.plusDays(3);
                } else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                    return date.plusDays(2);
                } else {
                    return date.plusDays(1);
                }
            }
        });
        System.out.println("下一个工作日是：" + nextWorkingDay);
    }

    /**
     * 两个LocalDateTime之间的差值使用Duration表示
     *
     * <p>类似PT1235H10M30S，表示1235小时10分钟30秒。而两个LocalDate之间的差值用Period表示，类似P1M21D，表示1个月21天。
     *
     * <p>Duration和Period的表示方法也符合ISO 8601的格式，它以P...T...的形式表示，P...T之间表示日期间隔，T后面表示时间间隔。如果是PT...的格式表示仅有时间间隔。利用ofXxx()
     * <p>parse()方法也可以直接创建Duration：
     */
    @Test
    @DisplayName("Duration和Period")
    public void whenDurationAndPeriodSuccess() {
        LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
        LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
        Duration d = Duration.between(start, end);
        // PT1235H10M30S
        System.out.println(d);

        Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
        // P1M21D
        System.out.println(p);

        // 10 hours
        Duration d1 = Duration.ofHours(10);
        // 1 day, 2 hours, 3 minutes
        Duration d2 = Duration.parse("P1DT2H3M");
    }
    
    @Test
    @DisplayName("旧API转新API")
    public void whenOldApiToNewApiSuccess() {
        // Date -> Instant -> LocalDateTime
        LocalDateTime fromDate =
                new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        // Calendar -> Instant -> ZonedDateTime -> LocalDateTime
        LocalDateTime fromCalendar =
                Calendar.getInstance().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    @Test
    @DisplayName("新API转旧API")
    public void whenNewApiToOldApiSuccess() {

        // LocalDateTime -> Instant -> Date
        Instant instantFromLocalDateTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
        Date dateFromLocalDateTime = Date.from(instantFromLocalDateTime);

        // ZonedDateTime -> Instant -> Date
        Instant instantFromZonedDateTime = ZonedDateTime.now().toInstant();
        Date dateFromZonedDateTime= Date.from(instantFromZonedDateTime);

    }
}
