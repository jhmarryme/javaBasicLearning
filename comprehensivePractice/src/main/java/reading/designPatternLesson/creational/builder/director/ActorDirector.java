package reading.designPatternLesson.creational.builder.director;

import reading.designPatternLesson.creational.builder.builder.ActorBuilder;
import reading.designPatternLesson.creational.builder.product.Actor;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 12:20
 * @Modified By:
 */
public class ActorDirector {
    public Actor build(ActorBuilder builder){
        Actor actor;
        builder.buildCostume();
        builder.buildSex();
        builder.buildType();
        actor = builder.build();
        return actor;
    }
}
