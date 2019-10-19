package designPatternLesson.decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/14 11:42
 */
public class GreenApple implements Apple {
    @Override
    public Animal getSuperPowerPig(Animal pig) {
        return new FastPig(pig);
    }
}
