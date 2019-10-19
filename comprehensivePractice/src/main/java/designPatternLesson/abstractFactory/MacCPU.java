package designPatternLesson.abstractFactory;

/**
 * 具体产品
 */
public class MacCPU implements CPU{

    @Override
    public void display() {
        System.out.println("MacCPU");
    }
}