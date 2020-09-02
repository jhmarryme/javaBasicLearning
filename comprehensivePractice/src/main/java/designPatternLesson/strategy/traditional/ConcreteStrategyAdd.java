package designPatternLesson.strategy.traditional;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/1 10:40
 * @Modified By:
 */
public class ConcreteStrategyAdd implements IStrategy {
    @Override
    public int exec(int a, int b) {
        return a + b;
    }
}
