package designPatternLesson.abstractFactory;

/**
 * 具体产品
 */
public class PcRAM implements RAM{

    @Override
    public void display() {
        System.out.println("PcRAM");
    }
}