package coreJava.reflect;

import imooc.javaBasic.reflect.Robot;
import javaBase.enumBase.enumLearning.Pizza;
import lombok.Data;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/8/13 10:46
 * @Modified By:
 */
@Data
public class ReflectExample {

    @SneakyThrows
    @Test
    public void reflectForRobot() {
        Class<?> robotClass = Class.forName("imooc.javaBasic.reflect.Robot");
        Robot robot = (Robot) robotClass.newInstance();

        Field name = robotClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(robot, "jhmarryme");

        // 获取私有的字段
        System.out.println("name.get(robot) = " + name.get(robot));
    }
}
