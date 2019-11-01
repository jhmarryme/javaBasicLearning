package designPatternLesson.decorator;

/**
 * 抽象装饰者
 * @author jhmarryme.cn
 * @date 2019/10/14 11:20
 */
public abstract class DecoratorPig extends Animal {

    private Animal pig;

    public DecoratorPig(Animal pig) {
        this.pig = pig;
    }
    @Override
    public void run() {
        this.pig.run();
    }

    @Override
    public void beBiiten() {
        this.pig.beBiiten();
    }
}
