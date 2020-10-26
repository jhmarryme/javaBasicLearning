package reading.imooc.javaBasic.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author jhmarryme.cn
 * @date 2019/9/9 18:47
 */
public class LoadClassDifference {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 通过loadClass方法加载的类不会进行, 链接接和初始化, 不会执行static代码块
        ClassLoader cl = Robot.class.getClassLoader();
        Class<?> r = cl.loadClass("reading.imooc.javabasic.reflect.Rebot");
        Robot robot = (Robot) r.newInstance();

        // 通过forName方法加载的类会进行初始化
        final Class<?> rc = Class.forName("reading.imooc.javabasic.reflect.Rebot");
        Robot robot1 = (Robot) rc.newInstance();
        robot.sayHi("ss");

        final Method throwHello = rc.getDeclaredMethod("throwHello", String.class);
        throwHello.setAccessible(true);
        throwHello.invoke(robot1, "sss");

    }
}
