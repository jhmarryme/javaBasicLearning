package designPatternLesson.decorator;

/**
 * 被装饰之后的猪, 免疫伤害
 * @author jhmarryme.cn
 * @date 2019/10/14 11:36
 */
public class ProtectedPig extends DecoratorPig {

    public ProtectedPig(Animal pig) {
        super(pig);
    }

    @Override
    public void beBiiten() {
        System.out.println("小猪被咬了, 但是现在不会受到伤害");
    }
}
