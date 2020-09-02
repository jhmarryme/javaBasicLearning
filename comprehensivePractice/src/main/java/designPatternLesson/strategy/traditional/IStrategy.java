package designPatternLesson.strategy.traditional;

/**
 * description: 抽象策略接口
 *
 * @Author: Wjh
 * @Date: 2020/9/1 10:38
 * @Modified By:
 */
public interface IStrategy {
    /**
     *  简单的运算
     *
     * @Param: [a, b]
     * @Return: int
     * @Author: Wjh
     * @Since: 2020/9/1 10:39
     * @Throws
     **/
    int exec(int a, int b);
}
