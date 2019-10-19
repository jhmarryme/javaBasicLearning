package designPatternLesson.abstractFactory;

/**
 * 具体工厂
 */
public class MacFactory implements AbstractFactory{

    @Override
    public RAM getRAM() {
        return new MacRAM();
    }

    @Override
    public CPU getCPU() {
        return new MacCPU();
    }
}