package designPatternLesson.builder;

/**
 * @author jhmarryme.cn
 * @date 2019/11/1 17:26
 */
public class HeroBuilder extends ActorBuilder {
    @Override
    public void bulidType() {
        actor.setType("英雄");
    }

    @Override
    public void bulidSex() {
        actor.setSex("男");
    }

    @Override
    public void bulidCostume() {
        actor.setCostume("盔甲");
    }
}
