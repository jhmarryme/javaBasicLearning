package designPatternLesson.creational.builder;

import designPatternLesson.creational.builder.concreteBuilder.HeroBuilder;
import designPatternLesson.creational.builder.concreteBuilder.SuperHeroBuilder;
import designPatternLesson.creational.builder.director.ActorDirector;
import designPatternLesson.creational.builder.product.Actor;
import org.junit.jupiter.api.Test;

/**
 * description: 
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
