package designPatternLesson.creational.builder.concreteBuilder;

import designPatternLesson.creational.builder.builder.ActorBuilder;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 12:18
 * @Modified By:
 */
public class HeroBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("盔甲");
    }
}
