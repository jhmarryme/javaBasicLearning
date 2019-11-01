package designPatternLesson.builder;

/**
 * @author jhmarryme.cn
 * @date 2019/11/1 17:27
 */
public class ActorController {
    public Actor build(ActorBuilder builder){
        Actor actor;
        builder.bulidCostume();
        builder.bulidSex();
        builder.bulidType();
        actor = builder.build();
        return actor;
    }
}
