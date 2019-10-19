package designPatternLesson.decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/14 11:43
 */
public class YellowApple implements Apple {
    @Override
    public Animal getSuperPowerPig(Animal pig) {
        return new SwimPig(pig);
    }
}
