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

        // 小猪佩奇
        final Pig page = new Pig();
        System.out.println("我是小猪佩奇");
        page.run();
        page.beBiiten();
        System.out.println();
        System.out.println();

        // 小猪吃了红苹果   包装佩奇
        final RedApple redApple = new RedApple();
        final Animal superPage = redApple.getSuperPowerPig(page);
        System.out.println("佩奇吃了一个红苹果, 变身超神佩奇");
        superPage.run();
        superPage.beBiiten();
        System.out.println();
        System.out.println();
        // 再次包装佩奇
        final Animal superSuperPage = new GreenApple().getSuperPowerPig(superPage);
        System.out.println("佩奇吃了一个绿苹果, 变身无敌佩奇");
        superSuperPage.run();
        superSuperPage.beBiiten();
        System.out.println();
        System.out.println();
        // 再次包装佩奇 无敌佩奇
        final SwimPig godPage = new YellowApple().getSuperPowerPig(superSuperPage);
        System.out.println("佩奇吃了一个黄苹果, 佩奇成神了");
        godPage.run();
        godPage.beBiiten();
        godPage.swim();
        System.out.println();
        System.out.println();
    }
}
