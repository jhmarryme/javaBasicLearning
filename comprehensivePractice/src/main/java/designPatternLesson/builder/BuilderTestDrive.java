package designPatternLesson.builder;

/**
 * @author jhmarryme.cn
 * @date 2019/11/1 17:29
 */
public class BuilderTestDrive {

    public static void main(String[] args) {

        ActorBuilder builder = new HeroBuilder();

        Actor actor = new ActorController().build(builder);

        System.out.println(actor.toString());
    }
}
