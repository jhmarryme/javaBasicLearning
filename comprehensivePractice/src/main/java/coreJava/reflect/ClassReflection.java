package coreJava.reflect;

import coreJava.stream.User;
import imooc.javaBasic.reflect.Robot;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @program: core-java
 * @description:
 * @author: JiaHao Wang
 * @create: 2020-07-02 10:31
 **/
public class ClassReflection {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("user.getClass().getName() = " + user.getClass().getName());
    }

    @Test
    public void testClassRef() {


        // Object类中的getClass()方法
        Class<? extends User> userClass = new User().getClass();
        System.out.println("userClass.getName() = " + userClass.getName());

        // Class.forName() 获取类名对象的class对象
        Class<?> forName = null;
        try {
            forName = Class.forName("study.stream.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("forName.getName() = " + forName.getName());

        // 如果T是任意的Java类型(或void关键字), T.class代表匹配的类对象
        Class<User> userClass1 = User.class;
        System.out.println("userClass1.getName() = " + userClass1.getName());


        Class randomClass = Random.class;

        Class integerClass = int.class;

        Class aClass = Double[].class;

        System.out.println("aClass.getName() = " + aClass.getName());


        // getConstructor
        try {
            Class<?> randomClass2 = Class.forName("java.util.Random");
            Object o = randomClass2.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    @Test
    public void testReflection() {

        Class<?> rc = Class.forName("study.reflection.Rebot");
        Robot r = (Robot) rc.newInstance();
        //getDeclaredMethod可以获取到包括私有, 但是不包括继承来的所有方法
        Method throwHello = rc.getDeclaredMethod("throwHello", String.class);
        //私有的方法或字段, 需要设置
        throwHello.setAccessible(true);
        //需要传入的参数为r
        Object str = throwHello.invoke(r, "王家豪");
        System.out.println("throwHello 's result is " + str);

        //getMethod不能获取到私有的方法, 但是可以获取到继承的方法
        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r, "你好啊");

        //获取私有的字段  通过String getPrivateName = (String)name.get(r); 获取该变量的值
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);

        name.set(r, "江航");
        String getPrivateName = (String)name.get(r);
        System.out.println("getPrivateName = " + getPrivateName);

        sayHi.invoke(r, "你好啊");

    }
}
