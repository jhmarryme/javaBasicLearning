package javaBase.optional;

import base.entity.Student;
import base.entity.User;
import base.exception.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import utils.CreateUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * description: java Optional 使用
 *
 *  参考链接: https://www.jianshu.com/p/82ed16613072
 *
 * @Author: Wjh
 * @Date: 2020/9/2 11:18
 * @Modified By:
 */
public class OptionalTestDrive {

    /**
     * 创建Optional
     *
     * 1.Optional.of(T value)，该方法通过一个非 null 的 value 来构造一个 Optional，
     *      返回的 Optional 包含了 value 这个值。对于该方法，传入的参数一定不能为 null，否则便会抛出 NullPointerException。
     *
     * 2.Optional.ofNullable(T value)，该方法和 of 方法的区别在于，传入的参数可以为 null
     *
     * 3.Optional.empty()，该方法用来构造一个空的 Optional，即该 Optional 中不包含值 —— 其实底层实现还是 如果 Optional 中的 value 为 null
     * 则该 Optional 为不包含值的状态，然后在 API 层面将 Optional 表现的不能包含 null 值，使得 Optional 只存在 包含值 和 不包含值 两种状态。
     *
     * @Author: Wjh
     * @Since: 2020/9/2 12:00
     **/
    @Test
    public void createOptional() {
        Student student = CreateUtils.createStudent(false);

        // 1. of
        // Student(id=4, name=wjh, age=24, sex=男)
        Optional.of(student).ifPresent(System.out::println);

        // 2. ofNullable
        Optional.ofNullable(student).ifPresent(System.out::println);
        Student emptyStudent = CreateUtils.createStudent(true);
        // Student(id=null, name=null, age=null, sex=null)
        Optional.ofNullable(emptyStudent).ifPresent(System.out::println);
        // 无输出
        Optional.ofNullable(null).ifPresent(System.out::println);

        // 3. empty()
        Optional.empty().ifPresent(o -> System.out.println("not null"));
    }

    /**
     * Optional操作
     *
     * 1.ifPresent
     *      如果 Optional 中有值，则对该值调用 consumer.accept，否则什么也不做。
     *
     * 2.orElse
     *      如果 Optional 中有值则将其返回，否则返回 orElse 方法传入的参数。
     *
     * 3.orElseGet
     *      orElseGet 与 orElse 方法的区别在于，orElseGet 方法传入的参数为一个 Supplier 接口的实现 —— 当 Optional 中有值的时候，返回值；
     *      当 Optional 中没有值的时候，返回从该 Supplier 获得的值。
     *
     * 4.orElseThrow
     *      orElseThrow 与 orElse 方法的区别在于，orElseThrow 方法当 Optional 中有值的时候，返回值；没有值的时候会抛出异常，抛出的异常由传入的 exceptionSupplier 提供。
     *
     * 5.map
     *      如果当前 Optional 为 Optional.empty，则依旧返回 Optional.empty；否则返回一个新的 Optional，该 Optional 包含的是：函数 mapper 在以 value 作为输入时的输出值。
     *
     * 6.flatMap
     *      flatMap 方法与 map 方法的区别在于，map 方法参数中的函数 mapper 输出的是值，然后 map 方法会使用 Optional.ofNullable 将其包装为 Optional；而 flatMap 要求参数中的函数 mapper 输出的就是 Optional。
     *
     * 7.filter
     *  filter 方法接受一个 Predicate 来对 Optional 中包含的值进行过滤，如果包含的值满足条件，那么还是返回这个 Optional；否则返回 Optional.empty。
     *
     * 8. JAVA9 新功能
     *  public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier)
     *  or 方法的作用是，如果一个 Optional 包含值，则返回自己；否则返回由参数 supplier 获得的 Optional
     *
     *  public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)
     *  ifPresentOrElse 方法的用途是，如果一个 Optional 包含值，则对其包含的值调用函数 action，即 action.accept(value)，这与 ifPresent 一致；
     *  与 ifPresent 方法的区别在于，ifPresentOrElse 还有第二个参数 emptyAction ——
     *  如果 Optional 不包含值，那么 ifPresentOrElse 便会调用 emptyAction，即 emptyAction.run()
     *
     *  public Stream<T> stream()
     *  stream 方法的作用就是将 Optional 转为一个 Stream，如果该 Optional 中包含值，那么就返回包含这个值的 Stream；
     *  否则返回一个空的 Stream（Stream.empty()）。
     *
     *
     * @Author: Wjh
     * @Since: 2020/9/2 12:09
     **/
    @Test
    public void useOptional() {
        // 1. ifPresent
        Student student = CreateUtils.createStudent(false);
        Optional.ofNullable(student).ifPresent(stu -> System.out.println("stu = " + stu));

        // 2. orElse
        // 不为null, 直接返回值
        System.out.println("Optional.ofNullable(student).orElse(CreateUtils.createStudent(false)) = "
                + Optional.ofNullable(student).orElse(CreateUtils.createStudent(true)));
        student = null;
        // 为null, 返回一个 初始的Student对象
        System.out.println("Optional.ofNullable(student).orElse(CreateUtils.createStudent(false)) = "
                + Optional.ofNullable(student).orElse(CreateUtils.createStudent(true)));

        // 3. orElseGet
        System.out.println("Optional.ofNullable(student).orElseGet(() -> CreateUtils.createStudent(false)) = "
                + Optional.ofNullable(student).orElseGet(() -> CreateUtils.createStudent(false)));

        // 4. orElseThrow
        try {
            Optional.ofNullable(student).orElseThrow(() -> new EntityNotFoundException("没有找到Student"));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }


        // 5-7.....

        // 8-1. or
        // 为空, 返回一个Optional
        System.out.println("Optional.ofNullable(student).or(() -> Optional.ofNullable(CreateUtils.createStudent(false))).get() = "
                + Optional.ofNullable(student).or(() -> Optional.ofNullable(CreateUtils.createStudent(false))).get());

        // 8-2 ifPresentOrElse

        Optional.ofNullable(student)
                .ifPresentOrElse(stu -> System.out.println("============\nstu = " + stu), () -> System.out.println("student is null"));

        // 8-3 stream
        CreateUtils.createUserList(true)
                .stream()
                .map(Optional::ofNullable)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 将List<User> 转换为 List<Optional<User>>
        List<Optional<User>> collect = CreateUtils.createUserList(true)
                .stream()
                .map(Optional::ofNullable)
                .filter(Optional::isPresent)
                .collect(Collectors.toList());

        // 将 List<Optional<User>> 转换为  List<Stream<User>>
        List<Stream<User>> collect1 = collect.stream()
                .map(Optional::stream)
                .collect(Collectors.toList());

        // 将 List<Optional<User>> 转为  List<User>
        List<User> collect2 = collect.stream()
                .map(Optional::get)
                .collect(Collectors.toList());
        collect2.forEach(System.out::println);

        System.out.println("-------------------------------------------------");


        // java 9 中
        CreateUtils.createUserList(false)
                .stream()
                .map(Optional::ofNullable)
                .flatMap(Optional::stream)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // 将 List<Optional<User>> 转换为 List<User>
        List<User> collect3 = collect.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        Stream<User> userStream = collect.stream()
                .flatMap(Optional::stream);

    }



}
