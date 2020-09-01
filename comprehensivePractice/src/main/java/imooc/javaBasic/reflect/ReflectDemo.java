package imooc.javaBasic.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jhmarryme.cn
 * @date 2019/7/24 19:27
 */
public class ReflectDemo {

    /**
     * Class.forName的使用练习
     * 通过反射动态获取 对象 属性 方法
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {

        Class<?> rc = Class.forName("imooc.javaBasic.reflect.Robot");
        // Class.getDeclaredConstructor(...).newInstance(...) 替换 newInstance
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

        //获取私有的字段
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);

        name.set(r, "江航");
        sayHi.invoke(r, "你好啊");

    }
}
