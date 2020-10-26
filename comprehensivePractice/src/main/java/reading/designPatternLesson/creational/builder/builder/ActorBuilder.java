package reading.designPatternLesson.creational.builder.builder;

import reading.designPatternLesson.creational.builder.product.Actor;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 12:15
 * @Modified By:
 */
public abstract class ActorBuilder {

    protected Actor actor = new Actor();

    public abstract void buildType();
    public abstract void buildSex();
    public abstract void buildCostume();

    public Actor build(){
        return actor;
    }
}
