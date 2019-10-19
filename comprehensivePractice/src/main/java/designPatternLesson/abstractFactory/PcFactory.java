package designPatternLesson.abstractFactory;

/**
 * 具体工厂
 */
public class PcFactory implements AbstractFactory{

    @Override
    public RAM getRAM() {
        return new PcRAM();
    }

    @Override
    public CPU getCPU() {
        return new PcCPU();
    }
}