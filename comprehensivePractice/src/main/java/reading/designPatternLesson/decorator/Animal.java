package reading.designPatternLesson.decorator;

/**
 * 抽象动物类
 * @author jhmarryme.cn
 * @date 2019/10/14 11:11
 */
public abstract class Animal {
    private int lifePoint;

    public Animal() {
        this.lifePoint = 5;
    }


    /**
     * 返回当前生命值
     * @return
     */
    public int getLifePoint() {
        return lifePoint;
    }

    public void reduceLP(){
        this.lifePoint -= 1;
        System.out.println("小猪-1 LP, 剩余LP : " + this.lifePoint);
    }

    abstract void run();
    abstract void beBiiten();
}
