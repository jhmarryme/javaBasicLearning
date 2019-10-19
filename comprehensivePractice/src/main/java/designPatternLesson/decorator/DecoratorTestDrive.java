package designPatternLesson.decorator;

/**
 * “小猪逃命”游戏：一只小猪和一只灰狼，小猪最多5条命，灰狼每咬到小猪一次，小猪就要少一条命，小猪的任务是要逃过灰狼的追咬到猪栏。
 * 在逃的过程中小猪可以吃到三种苹果，吃“红苹果”可以给小猪加上保护罩，吃“绿苹果”可以加快小猪奔跑速度，吃“黄苹果”可以使猪趟着水跑。
 * 小猪如果吃多种苹果的话，小猪可以拥有多种苹果提供的功能。
 * @author jhmarryme.cn
 * @date 2019/10/14 11:26
 */
public class DecoratorTestDrive {
    public static void main(String[] args) {

        final Pig page = new Pig();

        page.run();
        page.beBiiten();

        final RedApple redApple = new RedApple();
        final Animal superPage = redApple.getSuperPowerPig(page);
        superPage.run();
        superPage.beBiiten();

        final Animal superSuperPage = new GreenApple().getSuperPowerPig(superPage);
        superSuperPage.run();
        superSuperPage.beBiiten();

        final Animal godPage = new YellowApple().getSuperPowerPig(superSuperPage);
        godPage.run();
        godPage.beBiiten();
    }
}
