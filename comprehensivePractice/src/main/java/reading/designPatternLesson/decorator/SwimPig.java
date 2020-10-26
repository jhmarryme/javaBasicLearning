package reading.designPatternLesson.decorator;

/**
 * 被装饰之后的猪, 会游泳
 * @author jhmarryme.cn
 * @date 2019/10/14 11:34
 */
public class SwimPig extends DecoratorPig {
    public SwimPig(Animal pig) {
        super(pig);
    }

    @Override
    public void run() {
        super.run();
    }

    public void swim(){
        System.out.println("小猪现在可以游泳了");
    }
}
