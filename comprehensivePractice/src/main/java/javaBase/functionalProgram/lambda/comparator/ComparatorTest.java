package javaBase.functionalProgram.lambda.comparator;

import javaBase.functionalProgram.stream.practice.StreamMethodsUse;
import base.entity.User;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;


/**
 * @program: core-java
 * @description: comparator的简单使用
 * @author: JiaHao Wang
 * @create: 2020-07-06 00:15
 **/
public class ComparatorTest {

    @Test
    public void testComparator() {

        List<User> userList = StreamMethodsUse.getUserData();
        userList.forEach(System.out::println);

        // 根据 int类型排序
        userList.sort(Comparator.comparingInt(User::getAge));
        userList.forEach(System.out::println);
        System.out.println("--------");


        // 根据userName 长度 排序
        userList.sort(Comparator.comparing(User::getUserName, Comparator.comparingInt(String::length)));

        // 根据性别排序后, 再根据年龄排序
        userList.sort(Comparator.comparingInt(User::getGender).thenComparingInt(User::getAge));
        userList.forEach(System.out::println);
        System.out.println("--------");

        // 存在空的排序字段
        userList.sort(Comparator.comparing(User::getTest, Comparator.nullsFirst(Comparator.reverseOrder())).thenComparing(User::getAge));
        userList.sort(Comparator.comparing(User::getTest, Comparator.nullsFirst(Comparator.naturalOrder())).thenComparing(User::getAge));
        userList.forEach(System.out::println);
        System.out.println("--------");

    }
}
