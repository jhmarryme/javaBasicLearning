package designPatternLesson.strategy.traditional;

import org.junit.jupiter.api.Test;

/**
 * description: 策略模式
 * 1. 定义抽象策略角色 IStrategy
 * 2. 定义具体策略角色 ConcreteStrategyAdd ConcreteStrategySub
 * 3. 封装角色 Calculator
 *
 * @Author: Wjh
 * @Date: 2020/9/1 10:42
 * @Modified By:
 */
public class Calculator {

    /** 策略 **/
    private IStrategy strategy;

    public Calculator() {
    }

    public Calculator(IStrategy strategy) {
        this.strategy = strategy;
    }



    public int exec(int a, int b) {
        return strategy.exec(a, b);
    }

}
