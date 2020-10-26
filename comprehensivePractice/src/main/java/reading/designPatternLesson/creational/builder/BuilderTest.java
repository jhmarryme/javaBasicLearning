package reading.designPatternLesson.creational.builder;

import reading.designPatternLesson.creational.builder.concreteBuilder.HeroBuilder;
import reading.designPatternLesson.creational.builder.concreteBuilder.SuperHeroBuilder;
import reading.designPatternLesson.creational.builder.director.ActorDirector;
import reading.designPatternLesson.creational.builder.product.Actor;
import org.junit.jupiter.api.Test;

/**
 * description: 建造者模式
 *     分步骤创建复杂对象。 该模式允许你使用相同的创建代码生成不同类型和形式的对象。
 * @Author: Wjh
 * @Date: 2020/10/12 12:13
 * @Modified By:
 */
public class BuilderTest {

    @Test
    public void whenCreateActorSuccess() {
        ActorDirector director = new ActorDirector();

        Actor superHero = director.build(new SuperHeroBuilder());

        Actor hero = director.build(new HeroBuilder());

        System.out.println(superHero.toString());
        System.out.println(hero.toString());
    }
}
