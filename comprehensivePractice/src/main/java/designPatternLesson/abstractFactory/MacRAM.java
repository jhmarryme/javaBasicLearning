package designPatternLesson.abstractFactory;

/**
 * 具体产品
 */
public class MacRAM implements RAM{

    @Override
    public void display() {
        System.out.println("MacRAM");
    }
}
