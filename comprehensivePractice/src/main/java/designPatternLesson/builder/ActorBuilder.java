package designPatternLesson.builder;

/**
 * @author jhmarryme.cn
 * @date 2019/11/1 17:20
 */
public abstract class ActorBuilder {

    protected Actor actor = new Actor();

    public abstract void bulidType();
    public abstract void bulidSex();
    public abstract void bulidCostume();

    public Actor build(){
        return actor;
    }
}
