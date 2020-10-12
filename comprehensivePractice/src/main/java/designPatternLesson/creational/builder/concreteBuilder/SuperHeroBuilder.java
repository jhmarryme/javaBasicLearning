package designPatternLesson.creational.builder.concreteBuilder;

import designPatternLesson.creational.builder.builder.ActorBuilder;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 12:19
 * @Modified By:
 */
public class SuperHeroBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("超级英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("超级盔甲");
    }
}
