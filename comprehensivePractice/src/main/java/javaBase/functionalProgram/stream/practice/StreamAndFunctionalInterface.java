package javaBase.functionalProgram.stream.practice;

import base.entity.Person;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jhmarryme.cn
 * @date 2019/7/24 11:21
 */
public class StreamAndFunctionalInterface {


    /**
     * 测试流的各种方法结合常用函数式接口的使用
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> one = new ArrayList<>();

        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");



//        1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
        one.stream().filter(s -> s.length() == 3).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        System.out.println("------------");

//        2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        one.stream().limit(3).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        System.out.println("------------");

//        3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
        two.stream().filter(s -> s.startsWith("张")).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        System.out.println("------------");

//        4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        two.stream().skip(2).collect(Collectors.toList()).forEach(s -> System.out.println(s));
        System.out.println("------------");

//        5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        Stream<String> stream = Stream.concat(one.stream(), two.stream());
//        stream.collect(Collectors.toList()).forEach(s -> System.out.println(s));
        System.out.println("------------");

//        6. 根据姓名创建`Person`对象；存储到一个新集合中。
//        7. 打印整个队伍的Person对象信息。
        stream.map(Person::new).collect(Collectors.toList()).forEach(person -> System.out.println(person.toString()));


        //8. 补充, 将list映射为map
        final Map<String, Person> map = Stream.concat(one.stream(), two.stream()).collect(Collectors.toMap(s -> s, s -> new Person(s)));
        final Set<Map.Entry<String, Person>> entries = map.entrySet();
        for (Map.Entry<String, Person> entry : entries) {
            System.out.print(entry.getKey());
            System.out.println(" : " + entry.getValue().toString());
        }

    }


}
