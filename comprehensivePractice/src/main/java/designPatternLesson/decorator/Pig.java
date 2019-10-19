package designPatternLesson.decorator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/14 11:11
 */
public class Pig extends Animal{

    /**
     * 普通奔跑方式
     */
    @Override
    public void run() {
        System.out.println("小猪在跑");
    }

    /**
     * 小猪被狼咬了一口
     */
    @Override
    public void beBiiten() {
        System.out.println("小猪被咬了");
        super.reduceLP();
    }


}
