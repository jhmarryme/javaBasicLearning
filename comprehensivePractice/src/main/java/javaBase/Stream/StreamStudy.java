package javaBase.Stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author jhmarryme.cn
 * @date 2019/7/4 16:52
 */
public class StreamStudy {

    /**
     * stream的一些练习操作
     * @param args
     */
    public static void main(String[] args) {

       /* List<String> strList = List.of("wjh", "jh", "jyh");
        List<String> intList = List.of("12", "100", "10000");
        Stream<String> stream = strList.stream();
//        stream.filter(s -> s.contains("jh")).forEach(s -> System.out.println("s = " + s));
        List<Integer> collect = intList.stream().map(s -> Integer.parseInt(s)).filter(integer -> integer >= 100).collect(Collectors.toList());
        Iterator<Integer> iterator = collect.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println("next = " + next);
        }*/

//        IntStream.of(new int[]{1, 2, 3}).forEach(value -> System.out.println("value = " + value));
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
    }
}
