package designPatternLesson.decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/14 11:42
 */
public class GreenApple implements Apple {
    /**
     * 吃了绿苹果的猪跑得飞快 返回超级猪
     * @param pig
     * @return
     */
    @Override
    public Animal getSuperPowerPig(Animal pig) {
        return new FastPig(pig);
    }
}
