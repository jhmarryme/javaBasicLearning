package designPatternLesson.abstractFactory;

/**
 * 具体产品
 */
public class PcCPU implements CPU{

    @Override
    public void display() {
        System.out.println("PcCPU");
    }
}
