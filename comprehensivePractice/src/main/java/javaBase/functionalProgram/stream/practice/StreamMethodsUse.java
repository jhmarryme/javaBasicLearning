package javaBase.functionalProgram.stream.practice;


import base.entity.User;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @program: core-java
 * @description: core java 11th volume2
 * Chapter 1. The Java SE 8 Stream Library
 * @author: JiaHao Wang
 * @create: 2020-07-01 15:58
 **/
public class StreamMethodsUse {

    /**
     * 创建流
     * 一: 1.2 卷2 p3 11th
     * <p>
     * java.util.stream.Stream
     * <p>
     * static <T> Stream<T> empty() 8
     * static <T> Stream<T> generate(Supplier<T> s) 8
     * static <T> Stream<T> iterate(T seed, UnaryOperator<T> f) 8
     * static <T> Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next) 8
     * static <T> Stream<T> ofNullable(T t) 9
     */
    @Test
    public void streamCreation() {

        // 一: 创建无限流的 静态方法 , 接收一个函数 (Supplier<T>接口的对象)

        // 1. 获取一个常量值的流 , 截取前100
        Stream.generate(() -> "Echo")
                .limit(100)
                .forEach(System.out::println);

        // 2. 获取一个随机数的流 , 截取前100
        Stream.generate(Math::random)
                .limit(100)
                .forEach(System.out::println);

        // 3. 类似 0 1 2 3 4 的序列  , 截取前100
        Stream.iterate(
                BigInteger.ZERO,
                bigInteger -> bigInteger.add(BigInteger.ONE)
        ).limit(100).forEach(System.out::println);


        // 二: 创建一个有限序列 0 ... 999  需要描述如何结束.  bigInteger -> bigInteger.compareTo(limit) < 0
        Stream.iterate(
                BigInteger.ZERO,
                bigInteger -> bigInteger.compareTo(new BigInteger("1000")) < 0,
                bigInteger -> bigInteger.add(BigInteger.ONE)
        ).forEach(System.out::println);

        Stream.iterate(
                0,
                integer -> integer.compareTo(1000) < 0,
                integer -> integer + 1
        ).forEach(System.out::println);

        // TODO 三: 创建一个非常短的流 卷2, p4
        System.out.println("Stream.ofNullable(null).count() = " + Stream.ofNullable(null).count());
        System.out.println("Stream.ofNullable(100).count() = " + Stream.ofNullable(100).count());
    }


    /**
     * filter, map, flatMap
     * 一: 1.3 卷2 p8 11th
     */
    @Test
    public void filterMapFlatMapMethods() {

        // filter
        getUserData().stream()
                .filter(user -> user.getGender() == 1 && user.getAge() > 50)
                .forEachOrdered(user -> { System.out.println("user = " + user); });

        // mapToInt
        Stream.of("1", "2", "3")
                .mapToInt(Integer::parseInt)
                .forEach(value -> { System.out.println("value = " + value); });

        // mapToDouble
        Stream.of("1", "2", "3")
                .mapToDouble(Double::parseDouble)
                .forEach(value -> { System.out.println("value = " + value); });

        // flatMap
        // 当你的 Stream 是以下这几种结构的时候，需要用到 flatMap方法，用于将原有二维结构扁平化。
        //Stream<String[]>
        //Stream<Set<String>>
        //Stream<List<String>>
        List<User> users = getUserData();
        List<User> users1 = getUserData();
        List<List<User>> userList = new ArrayList<>();
        userList.add(users);
        userList.add(users1);

        userList.stream()
                .flatMap(Collection::stream)
                .map(user -> user.getUserName() + user.getUserId())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * 抽取子流和组合流
     * 一: 1.4 卷2 p9 11th
     * <p>
     * java.util.stream.Stream
     * <p>
     * Stream<T> limit(long maxSize) 8
     * Stream<T> skip(long n) 8
     * static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b) 8
     * Stream<T> takeWhile(Predicate<? super T> predicate) 9
     * Stream<T> dropWhile(Predicate<? super T> predicate) 9
     */
    @Test
    public void extractingSubstreamsAndCombiningStreams() {

        // 为真时丢弃元素, 产生一个由第一个使该条件为假的字符开始的所有元素构成的流
        // 丢弃 不是以 'ca' 开头的
        Stream.of("a", "b", "ca", "abc")
                .dropWhile(s -> !s.startsWith("ca"))
                .forEach(System.out::println);
        System.out.println("--------");

        // 返回给定 Stream 的子集直到断言语句第一次返回 false。
        // 如果第一个值不满足断言条件，将返回一个空的 Stream。
        // 找到 不是以 'c' 开头的
        Stream.of("a", "b", "c", "abc")
                .takeWhile(s -> !s.startsWith("c"))
                .forEach(System.out::println);
        System.out.println("--------");

        // limit 获取前 n 条数据
        Stream.of("a", "b", "c")
                .limit(1)
                .forEach(System.out::println);
        System.out.println("--------");

        // skip 跳过前 n 条数据
        Stream.of("a", "b", "c")
                .skip(2)
                .forEach(System.out::println);
        System.out.println("--------");
    }

    /**
     * 流转换
     * 一: 1.5 卷2 p10 11th
     * <p>
     * java.util.stream.Stream 8
     * <p>
     * Stream<T> distinct()
     * Stream<T> sorted()
     * Stream<T> sorted(Comparator<? super T> comparator)
     * Stream<T> peek(Consumer<? super T> action)
     */
    @Test
    public void otherStreamTransformations() {

        // distinct 去重
        Stream<String> distinctStream = Stream.of("a", "b", "c", "a").distinct();
//        Assert.assertEquals(3, distinctStream.count());

        // peek 建立一个通道，在这个通道中对 Stream 的每个元素执行对应的操作，对应 Consumer<T>的函数式接口
        // 这是一个消费者函数式接口，顾名思义，它是用来消费 Stream 元素的
        // 比如下面这个方法，把每个元素转换成对应的大写字母并输出。
        // 不会真正消费掉这个Stream流
        Stream<String> peekStream = Stream.of("a", "b", "c");
        List<String> collect = peekStream
                .peek(s -> { System.out.println("s.toUpperCase() = " + s.toUpperCase()); })
                .collect(Collectors.toList());

        // sorted
        // 有两个重载，一个无参数，另外一个有个 Comparator类型的参数。
        // 无参类型的按照自然顺序进行排序，只适合比较单纯的元素，比如数字、字母等。
        Stream<String> sortedStream = Stream.of("a2", "c1", "b3");
        sortedStream.sorted(
                (o1, o2) -> Integer.parseInt(o1.substring(1)) > Integer.parseInt(o2.substring(1)) ? -1 : 1
        ).forEachOrdered(s -> { System.out.println("s = " + s); });

    }

    /**
     * 简单约简, 终结操作
     * 一: 1.6 卷2 p11 11th
     * <p>
     * java.util.stream.Stream 8
     * <p>
     * long count()
     * Optional<T> max(Comparator<? super T> comparator)
     * Optional<T> min(Comparator<? super T> comparator)
     * Optional<T> findFirst()
     * Optional<T> findAny()
     * boolean anyMatch(Predicate<? super T> predicate)
     * boolean allMatch(Predicate<? super T> predicate)
     * boolean noneMatch(Predicate<? super T> predicate)
     * void forEach(Consumer<? super T> action)
     * Object[] toArray()
     * <A> A[] toArray(IntFunction<A[]> generator)
     * <p>
     * java.util.stream.BaseStream 8
     * <p>
     * Iterator<T> iterator()
     */
    @Test
    public void simpleReductions() {

        // count
        Stream<String> countStream = Stream.of("a", "b", "c");
        System.out.println("countStream.count() = " + countStream.count());

        // max 求集合中的最大值 接收一个 Comparator<T>
        Stream<String> maxStream = Stream.of("a", "b", "c");
        System.out.println("maxStream.max(String::compareTo).get() = " + maxStream.max(String::compareTo).get());

        // min
        Stream<Integer> minStream = Stream.of(2, 2, 100, 5);
        System.out.println("minStream.min(Integer::compareTo).get() = " + minStream.min(Integer::compareTo).get());

        // findFirst 获取 Stream 中的第一个元素。
        Stream<Integer> firstStream = Stream.of(2, 2, 100, 5);
        System.out.println("firstStream.findFirst().get() = " + firstStream.findFirst().get());

        // findAny 获取 Stream 中的某个元素，如果是串行情况下，一般都会返回第一个元素，并行情况下就不一定了。
        Stream<Integer> anyStream = Stream.of(2, 2, 100, 5);
        System.out.println("anyStream.findAny().get() = " + anyStream.findAny().get());

        // anyMatch 任意元素匹配
        System.out.println("Stream.of(\"a\", \"b\", \"c\").anyMatch(s -> s.startsWith(\"c\")) = " + Stream.of("a", "b", "c").anyMatch(s -> s.startsWith("c")));

        // allMatch 所有元素匹配
        System.out.println("Stream.of(2, 2, 100, 5).allMatch(integer -> integer.compareTo(1) > 0) = " + Stream.of(2, 2, 100, 5).allMatch(integer -> integer.compareTo(1) > 0));

        // noneMatch 没有任何元素匹配
        System.out.println("Stream.of(\"a\", \"b\", \"c\").noneMatch(s -> s.endsWith(\"a\")) = " + Stream.of("a", "b", "c").noneMatch(s -> s.endsWith("a")));

    }

    /**
     * 收集结果
     * 一: 1.8 卷2 p19 11th
     * <p>
     * java.util.stream.Stream 8
     * <p>
     * <R,A> R collect(Collector<? super T,A,R> collector)
     * void forEach(Consumer<? super T> action)
     * Object[] toArray()
     * <A> A[] toArray(IntFunction<A[]> generator)
     */
    @Test
    public void collectingResults() {


        /*
           java.util.stream.Collectors 8

           static <T> Collector<T,?,List<T>> toList()
           static <T> Collector<T,?,Set<T>> toSet()
           static <T,C extends Collection<T>> Collector<T,?,C> toCollection(Supplier<C>
           static Collector<CharSequence,?,String> joining()
           static Collector<CharSequence,?,String> joining(CharSequence delimiter)
           static Collector<CharSequence,?,String> joining(CharSequence delimiter, CharSequence
           static <T> Collector<T,?,IntSummaryStatistics> summarizingInt(ToIntFunction<? super T> mapper)
           static <T> Collector<T,?,LongSummaryStatistics> summarizingLong(ToLongFunction<? super T> mapper)
           static <T> Collector<T,?,DoubleSummaryStatistics> summarizingDouble(ToDoubleFunction<? super T> mapper)
         */
        // joining
        System.out.println("Stream.of(\"a\", \"b\", \"c\").collect(Collectors.joining(\"!\")) = " + Stream.of("a", "b", "c")
                .collect(Collectors.joining("!")));

        // toCollection
        TreeSet<User> collect = getUserData().stream().collect(Collectors.toCollection(TreeSet::new));

        // summarizingInt 产生能够生成 (int|long|double) SummaryStatistics 对象的收集器, 进行结果的求和, 平均值, 最大值, 最小值, 数量
        IntSummaryStatistics intSummaryStatistics = getUserData().stream()
                .collect(Collectors.summarizingInt(User::getAge));
        /*
           long getCount()
           (int|long|double) getSum()
           double getAverage()
           (int|long|double) getMax()
           (int|long|double) getMin()
         */
        System.out.println("intSummaryStatistics.getAverage() = " + intSummaryStatistics.getAverage());

        // toArray
        int[] ints = Stream.of(1, 2, 3).mapToInt(Integer::intValue).toArray();


        // toArray2
        String[] strings = Stream.of("a", "b", "c").collect(Collectors.toList()).stream().toArray(String[]::new);

    }

    /**
     * 收集到映射表中
     * 一: 1.9 卷2 p24 11th
     */
    @Test
    public void collectingIntoMaps() {

        // toMap
        Map<Integer, String> integerStringMap = getUserData().stream()
                .collect(Collectors.toMap(User::getUserId, User::getUserName));

        // toMap 实际的元素作为值
        Map<Integer, User> integerUserMap = getUserData().stream()
                .collect(Collectors.toMap(User::getUserId, Function.identity()));

        // toMap 相同键情况 提供第3个函数引元
        Map<Integer, Integer> collect = getUserData().stream()
                .collect(Collectors.toMap(
                        User::getGender,
                        User::getAge,
                        (existingVal, newVal) -> existingVal));

        // toMap 相同键情况 进行并操作 set<String>
        // 使用 groupingBy 可以达到同样效果
        Map<Integer, Set<String>> setMap = getUserData().stream()
                .collect(Collectors.toMap(
                        User::getGender,
                        user -> Collections.singleton(user.getUserName()),
                        (a, b) -> {
                            HashSet<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                        }));

        // toMap  得到treeMap
        TreeMap<Integer, User> userTreeMap = getUserData().stream()
                .collect(Collectors.toMap(
                        User::getUserId,
                        Function.identity(),
                        (existingVal, newVal) -> {
                            throw new IllegalStateException();
                        },
                        TreeMap::new));
    }

    /**
     * 群组和分区
     * 一: 1.10 卷2 p27 11th
     */
    @Test
    public void groupingAndPartitioning() {
        // groupingBy 通过国家分组
        Map<String, List<Locale>> collect = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(Locale::getCountry));

        // partitioningBy 按是否满足条件分组
        // 分为使用英语和使用其他语言的两类
        Map<Boolean, List<Locale>> englishAndOtherLocales = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.partitioningBy(
                        locale -> "en".equals(locale.getLanguage())));
        System.out.println("======================");
        englishAndOtherLocales.get(true)
                .forEach(System.out::println);

        System.out.println("======================");
        englishAndOtherLocales.get(false)
                .forEach(System.out::println);
    }

    /**
     * 下游收集器
     * 一: 1.11 卷2 p28 11th
     */
    @Test
    public void downstreamCollectors() {
        // toSet 获得set而不是list
        Map<String, Set<Locale>> toSet = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(
                        Locale::getCountry,
                        Collectors.toSet())
                );

        // counting 每个国家有多少个locales
        Map<String, Long> counting = Stream.of(Locale.getAvailableLocales())
                .collect(Collectors.groupingBy(
                        Locale::getCountry,
                        Collectors.counting())
                );

        // summingInt 计算每个性别的年龄总和
        Map<Integer, Integer> summingInt = getUserData().stream()
                .collect(Collectors.groupingBy(
                        User::getGender,
                        Collectors.summingInt(User::getAge))
                );

        // maxBy 每个性别下 年龄最大的 user
        // minBy
        Map<Integer, Optional<User>> maxBy = getUserData().stream()
                .collect(Collectors.groupingBy(
                        User::getGender,
                        Collectors.maxBy(Comparator.comparingInt(User::getAge)))
                );

        // collectingAndThen 按照UserId分类, 并统计有多少种不同的结果
        // 作用与counting 差不多, 区别于 可以统计不同的结果
        Map<Integer, Integer> collectingAndThen = getUserData().stream()
                .collect(Collectors.groupingBy(
                        User::getGender,
                        Collectors.collectingAndThen(Collectors.toSet(), Set::size)
                ));

        // mapping 按照性别分组, 在每个组的内部, 将用户名收集到一个set中
        Map<Integer, Set<String>> mapping = getUserData().stream()
                .collect(Collectors.groupingBy(
                        User::getGender,
                        Collectors.mapping(User::getUserName, Collectors.toSet())
                ));

        // summarizingInt 从每个组的汇总统计对象中, 获取总和, 数量, 平均值..
        // 每个性别组下, 年龄的汇总对象
        Map<Integer, IntSummaryStatistics> summarizingInt = getUserData().stream()
                .collect(Collectors.groupingBy(
                        User::getGender,
                        Collectors.summarizingInt(User::getAge)
                ));

        // filtering 将一个过滤器应用到每个组上
        // 每个性别组下, 年龄大于20的set<User>
        Map<Integer, Set<User>> filtering = getUserData().stream()
                .collect(Collectors.groupingBy(
                        User::getGender,
                        Collectors.filtering(user -> user.getAge() > 20, Collectors.toSet())
                ));

        // flatMapping 当User中有List类型数据时, 展平List集合
        // 每个性别分组下, 将每个User下的List展开为 Set<String>
        Map<Integer, Set<String>> flatMapping2 = getUserData().stream()
                .collect(Collectors.groupingBy(
                        User::getGender,
                        Collectors.flatMapping(user -> user.getList().stream(), Collectors.toSet())
                ));
    }

    /**
     * 约简操作
     * 一: 1.12 卷2 p32 11th
     */
    @Test
    public void reductionOperations() {

        // reduce
        // 它的作用是每次计算的时候都用到上一次的计算结果
        // 比如求和操作，前两个数的和加上第三个数的和，再加上第四个数，一直加到最后一个数位置
        // 最后返回结果，就是 reduce的工作过程
        Stream<Integer> integerStream = Stream.of(1, 2, 5, 7, 8, 12, 33);
        Integer sum = integerStream.reduce(0, Integer::sum);
        System.out.println(sum);


        // 提供一个累积器 (total, s) -> total + s.length(),  提供一个函数将结果合并 Integer::sum
        Integer reduce = Stream.of("abc", "abde", "abe")
                .reduce(0,
                        (total, s) -> total + s.length(),
                        Integer::sum);
        System.out.println("reduce = " + reduce);


    }

    /**
     * 基本类型流
     * 一: 1.13 卷2 p34 11th
     */
    @Test
    public void primitiveTypeStreams() {
        // 创建IntStream
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 4}, 0, 3);
        // 0....99
        IntStream range = IntStream.range(0, 100);
        // 0....100
        IntStream rangeClosed = IntStream.rangeClosed(0, 100);

        // 对象流 -> 基本类型流
        IntStream mapToInt = Stream.of("1", "2", "3")
                .mapToInt(Integer::parseInt);

        // 基本类型流 -> 对象流
        Stream<Integer> boxed = IntStream.range(0, 100).boxed();


        // max, min. sum
        int sum = IntStream.range(0, 100).sum();
        int max = IntStream.range(0, 100).max().getAsInt();

        // 统计对象
        IntSummaryStatistics summaryStatistics = IntStream.range(0, 100).summaryStatistics();

        // toArray 基本类型
        int[] ints = IntStream.range(0, 100).toArray();

    }

    @Test
    public void distinctBySpecificField() {
        List<User> userData = getUserData();
        // 通过 username 去重
        ArrayList<User> distinctByUserName = userData.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(User::getUserName))
                        ),
                        ArrayList::new
                )
        );
        // 通过 username 和address 去重
        ArrayList<User> distinctByUserNameAndAddress = userData.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(user -> user.getUserName() + ";" + user.getAddress()))
                        ),
                        ArrayList::new
                )
        );
        // 通过 username 和address 去重并排序
        List<User> distinctAndSortByUserNameAndAddress = userData.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(
                                () -> new TreeSet<>(Comparator.comparing(user -> user.getUserName() + ";" + user.getAddress()))
                        ),
                        usersTreeSet -> usersTreeSet.stream().sorted().collect(Collectors.toList())
                )
        );
    }


    /**
     * 并行流
     * 一: 1.14 卷2 p39 11th
     */
    public void parallelStreams() {
        // Collection.parallelStream() 从集合中获取并行流
        Stream<User> userStream = getUserData().parallelStream();

        // parallel 将序列流 转为 并行流
        Stream<User> parallel = getUserData().stream().parallel();

        // TODO 剩余部分
    }


    /**
     * Stream 简单使用
     * <p>
     * Stream
     * <p>
     * Stream<T> filter(Predicate<? super T> predicate)
     * <R> Stream<R> map(Function<? super T,? extends R> mapper)
     * <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
     */
    @Test
    public void testMethods() {

        // collection.groupingBy 按照 userId 字段分组, 统计userId的个数
        // 返回以 userId 为key，每个 key 的个数为value
        Map<Integer, Long> integerLongMap = getUserData().stream().collect(Collectors.groupingBy(User::getUserId, Collectors.counting()));

        // 按照gender分组
        // key 为 gender值, value 为 List<User>
        Map<Integer, List<User>> groupingByGenderListUser = getUserData().stream().collect(Collectors.groupingBy(User::getGender));

        // 按照Gender分组,
        // key 为 gender值, value为 统计userName的List<String>
        Map<Integer, List<String>> groupingByGenderListString = getUserData().stream().collect(Collectors.groupingBy(User::getGender, Collectors.mapping(User::getUserName, Collectors.toList())));
        System.out.println("groupingByGenderListString = " + groupingByGenderListString);

        // toArray
        User[] toUserArray = getUserData().stream().filter(user -> user.getGender() == 0).toArray(User[]::new);
        String[] toStringArray = getUserData().stream().map(User::getUserName).toArray(String[]::new);
        for (User user : toUserArray) {
            System.out.println("user = " + user);
        }

        for (String s : toStringArray) {
            System.out.println("s = " + s);
        }


    }

    /**
     * 生成简单的List<User>
     *
     * @return
     */
    public static List<User> getUserData() {
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setUserId(i);
            user.setUserName(String.format("%s 号", i));
            user.setAge(random.nextInt(100));
            user.setGender(i % 2);
            user.setPhone("18812021111" + i);
            user.setAddress("无" + i);
            if (i % 2 == 0) {
                user.setTest("test" + i);
                List<String> list = user.getList();
                list.add("a" + i);
                list.add("b" + i);
                user.setList(list);
            }
            users.add(user);

        }
        return users;
    }
}
