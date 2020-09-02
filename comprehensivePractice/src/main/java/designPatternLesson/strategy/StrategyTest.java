package designPatternLesson.strategy;

import designPatternLesson.strategy.enumeration.BasicOperation;
import designPatternLesson.strategy.enumeration.ExtendedOperation;
import designPatternLesson.strategy.enumeration.Operation;
import designPatternLesson.strategy.traditional.Calculator;
import designPatternLesson.strategy.traditional.ConcreteStrategyAdd;
import designPatternLesson.strategy.traditional.ConcreteStrategySub;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/1 11:09
 * @Modified By:
 */
public class StrategyTest {

    /**
     *  测试传统的策略模式
     *
     * @Param: []
     * @Return: void
     * @Author: Wjh
     * @Since: 2020/9/1 11:10
     * @Throws
     **/
    @Test
    public void testTraditional() {
        // 使用不同的构造方法
        Calculator addCalculator = new Calculator(new ConcreteStrategyAdd());
        Calculator subCalculator = new Calculator(new ConcreteStrategySub());

        System.out.println("addCalculator.exec(4, 2) = " + addCalculator.exec(4, 2));
        System.out.println("subCalculator.exec(4, 2) = " + subCalculator.exec(4, 2));
    }

    /**
     *  使用接口模拟可扩展的枚举
     *  虽然不能编写可扩展的枚举类型，但是你可以编写一个接口来配合实现接口的基本的枚举类型，来对它进行模拟。
     *
     * @Param: []
     * @Return: void
     * @Author: Wjh
     * @Since: 2020/9/1 14:30
     * @Throws
     **/
    @Test
    public void testEnumeration() {
        double x = 4.0;
        double y = 2.0;
        testBasic(BasicOperation.class, x, y);
        testExtend(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    /**
     * 遍历ExtendedOperation 调用apply
     * 通过ExtendedOperation.values()获取所有的枚举值进行遍历
     * @Param: [opSet, x, y]
     * @Return: void
     * @Author: Wjh
     * @Since: 2020/9/1 14:31
     * @Throws
     **/
    private void testExtend(Collection<? extends Operation>opSet, double x, double y) {
        for (Operation op : opSet)
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }

    /**
     * 遍历BasicOperation 调用apply
     * 通过BasicOperation.class 获取到所有的枚举值进行遍历
     *
     * @Param: [enumType, x, y]
     * @Return: void
     * @Author: Wjh
     * @Since: 2020/9/1 14:33
     * @Throws 
     **/
    public static <T extends Enum<T> & Operation> void testBasic(Class<T>enumType,
                                                                 double x,
                                                                 double y) {
        for (Operation op : enumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f \n",x, op, y,  op.apply(x, y));
        }
    }
}
