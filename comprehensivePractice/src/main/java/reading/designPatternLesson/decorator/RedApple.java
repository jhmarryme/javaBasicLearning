package reading.designPatternLesson.decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/14 11:37
 */
public class RedApple implements Apple {

    /**
     * 吃了红苹果的猪不会受到伤害 返回超级猪
     * @param pig
     * @return
     */
    @Override
    public Animal getSuperPowerPig(Animal pig) {
        return new ProtectedPig(pig);
    }
}
