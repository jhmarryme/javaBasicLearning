package coreJava.lambda;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author jhmarryme
 * @date 2020/6/29 16:37
 */
public class MethodReferences {
    public static void main(String[] args) {

        // 使用自定义的函数式接口 Function
        Function<String, Integer> function = Integer::parseInt;
        Comparator<Integer> compare = Integer::compare;
        System.out.println("compare.compare(1, 2) = " + compare.compare(1, 2));
        System.out.println("function.apply(\"s\") = " + function.apply("12"));

        // 开启线程
        Runnable runnable = () -> System.out.println(1);
        new Thread(runnable).start();

        // 使用自定义的函数式接口 JhFunction
        JhFunction<LocalDateTime, String, String> localDateTimeStringStringBiFunction = (LocalDateTime dateTime, String pattern) -> {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(pattern);
            return dateTime.format(timeFormatter);
        };
        System.out.println("localDateTimeStringStringBiFunction.run(LocalDateTime.now(), \"yyyy-MM-dd HH:mm:ss\") = "
                + localDateTimeStringStringBiFunction.run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));

        // 使用预定义的函数式接口 BiFunction
        BiFunction<LocalDateTime, String, String> localDateTimeStringStringBiFunction1 = (LocalDateTime dateTime, String pattern) -> {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(pattern);
            return timeFormatter.format(dateTime);
        };
        System.out.println("localDateTimeStringStringBiFunction1.apply(LocalDateTime.now(), \"yyyy-MM-dd HH-mm-ss\") = "
                + localDateTimeStringStringBiFunction1.apply(LocalDateTime.now(), "yyyy-MM-dd HH-mm-ss"));

        // 处理日期字符串
        LocalDate parse = LocalDate.parse("20200319", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("parse = " + parse);

        // 日期格式化
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println("format = " + format);
    }


    @Test
    public void testForThreeCase() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        arrayList.forEach(System.out::println);

        // 删除空对象
        arrayList.removeIf(Objects::isNull);
    }
}
