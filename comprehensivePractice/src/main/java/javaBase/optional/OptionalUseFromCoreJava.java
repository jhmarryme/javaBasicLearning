package javaBase.optional;

import javaBase.functionalProgram.stream.practice.StreamMethodsUse;
import base.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @program: core-java
 * @description: Optional 练习
 * <p>
 * Optional类型的变量永远不应该为null
 * 不要使用Optional类型的域, 其代价是额外多出来一个对象. 在类的内部, 使用null表示缺失的域更易于操作
 * 不要在集合中放置Optional对象, 不要用作map的键, 应该直接收集其中的值
 * @author: JiaHao Wang
 * @create: 2020-07-06 14:36
 **/
public class OptionalUseFromCoreJava {

    /**
     * 获取optional值
     * 一: 1.7.1 卷2 p13 11th
     * <p>
     * java.util.Optional 8
     * <p>
     * T orElse(T other)
     * <p>
     * T orElseGet(Supplier<? extends T> other)
     * <p>
     * <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier)
     */
    @Test
    public void testGetOptional() {
        Optional<String> optional = Optional.empty();

        // orElse 为空时, 产生other
        System.out.println("optional.orElse(\"empty\") = " + optional.orElse("empty"));

        // orElseGet 为空时, 产生调用other的结果
        System.out.println("optional.orElseGet(() -> new String(\"orElseGet -> empty\")) = " + optional.orElseGet(() -> "orElseGet -> empty"));


        // orElseThrow 为空时, 抛出异常
        try {
            System.out.println("optional.orElseThrow(IllegalStateException::new) = " + optional.orElseThrow(IllegalStateException::new));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }


    /**
     * 消费optional值
     * 一: 1.7.2 卷2 p13 11th
     * <p>
     * java.util.Optional
     * <p>
     * void ifPresent(Consumer<? super T> action) 8
     * void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) 9
     */
    @Test
    public void testConsumption() {

        Optional<User> userOptional = Optional.empty();

        // ifPresent 如果不为空, 将值传递到action
        userOptional.ifPresent(User::toString);

        // ifPresentOrElse 如果不为空, 将值传递到action, 否则调用emptyAction
        userOptional.ifPresentOrElse(User::toString, () -> System.out.println("user error"));

    }

    /**
     * 管道化Optional值
     * 一: 1.7.3 卷2 p14 11th
     * <p>
     * java.util.Optional
     * <p>
     * <U> Optional<U> map(Function<? super T,? extends U> mapper) 8
     * Optional<T> filter(Predicate<? super T> predicate) 8
     * Optional<T> or(Supplier<? extends Optional<? extends T>> supplier) 9
     */
    @Test
    public void testPipelineOptional() {
        Optional<String> stringOptional = Optional.of("hello world");

        // map 转换optional内部的值
        System.out.println("stringOptional.map(String::toUpperCase).get() = " + stringOptional.map(String::toUpperCase).get());

        // map 将结果添加到列表中
        ArrayList<String> list = new ArrayList<>();
        stringOptional.map(list::add);
        list.forEach(System.out::println);

        // 结合 filter
        System.out.println("stringOptional.filter(s -> s.length() > 5).map(String::toUpperCase).get() = " + stringOptional.filter(s -> s.length() > 5).map(String::toUpperCase).get());

        // or 为空 由supplier产生一个optional
        System.out.println("Optional.empty().or(() -> Optional.of(\"new Optional\")).get() = " + Optional.empty().or(() -> Optional.of("new Optional")).get());
    }


    /**
     * 创建optional
     * 一: 1.7.5 卷2 p16 11th
     * <p>
     * java.util.Optional 8
     * <p>
     * static<T> Optional<T> empty()
     * static <T> Optional<T> of(T value)
     * static <T> Optional<T> ofNullable(T value) 9
     */
    @Test
    public void testCreateOptional() {

        // empty 创建一个空optional
        Optional<Object> empty = Optional.empty();

        // of 静态方法创建optional
        Optional<String> stringOptional = Optional.of("hello world");

        // ofNullable
        // 预防 NullPointerExceptions 异常， 可以通过检查流来避免 null 值。
        // 如果指定元素为非 null，则获取一个元素并生成单个元素流，元素为 null 则返回一个空流。
        Optional<Object> objectOptional = Optional.ofNullable(null);
    }

    /**
     * 将optional 转为 流
     * 使用flatMap构建optional值
     * 一: 1.7.6 / 1.7.7 卷2 p16 11th
     * <p>
     * java.util.Optional 8
     * <p>
     * <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)
     * <p>
     * java.util.Stream 8
     * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
     */
    @Test
    public void testFlatMap() {

        // flatMap 链式处理, 返回值保持不变,必须是Optional类型
        System.out.println("Optional.of(2).flatMap(integer -> Optional.of(integer * 2)).flatMap(integer -> Optional.of(integer * 2)).get() = " + Optional.of(2).flatMap(integer -> Optional.of(integer * 2)).flatMap(integer -> Optional.of(integer * 2)).get());

        // Stream.flatMap 将optional 转为 流
        Stream<User> userStream = StreamMethodsUse.getUserData().stream().map(Optional::of).flatMap(Optional::stream);
        userStream.forEach(System.out::println);
    }

}
