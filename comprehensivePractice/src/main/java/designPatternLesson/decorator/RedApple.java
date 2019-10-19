package designPatternLesson.decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/14 11:37
 */
public class RedApple implements Apple {

    @Override
    public Animal getSuperPowerPig(Animal pig) {
        return new ProtectedPig(pig);
    }
}
