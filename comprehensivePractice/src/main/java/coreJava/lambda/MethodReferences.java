package coreJava.lambda;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author jhmarryme
 * @date 2020/6/29 16:37
 */
public class MethodReferences {
    public static void main(String[] args) {
        Function<String, Integer> function = Integer::parseInt;
        Comparator<Integer> compare = Integer::compare;

        System.out.println("compare.compare(1, 2) = " + compare.compare(1, 2));

        System.out.println("function.apply(\"s\") = " + function.apply("12"));

        Runnable runnable = () -> System.out.println(1);
        new Thread(runnable).start();

        JhFunction<LocalDateTime, String, String> localDateTimeStringStringBiFunction = (LocalDateTime dateTime, String pattern) -> {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(pattern);
            return dateTime.format(timeFormatter);
        };
        System.out.println("localDateTimeStringStringBiFunction.run(LocalDateTime.now(), \"yyyy-MM-dd HH:mm:ss\") = " + localDateTimeStringStringBiFunction.run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
        BiFunction<LocalDateTime, String, String> localDateTimeStringStringBiFunction1 = (LocalDateTime dateTime, String pattern) -> {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(pattern);
            return timeFormatter.format(dateTime);
        };
        System.out.println("localDateTimeStringStringBiFunction1.apply(LocalDateTime.now(), \"yyyy-MM-dd HH-mm-ss\") = " + localDateTimeStringStringBiFunction1.apply(LocalDateTime.now(), "yyyy-MM-dd HH-mm-ss"));

 
        LocalDate parse = LocalDate.parse("20200319", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("parse = " + parse);

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        System.out.println("format = " + format);
    }
}
