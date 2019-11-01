package designPatternLesson.decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/14 11:43
 */
public class YellowApple implements Apple {

    /**
     * 吃了黄苹果的猪会游泳 返回超级猪
     * @param pig
     * @return
     */
    @Override
    public SwimPig getSuperPowerPig(Animal pig) {
        return new SwimPig(pig);
    }
}
