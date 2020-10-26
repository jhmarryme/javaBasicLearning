package reading.designPatternLesson.creational.abstractFactory.concreteFactory;

import reading.designPatternLesson.creational.abstractFactory.concreteProduct.PcCpu;
import reading.designPatternLesson.creational.abstractFactory.concreteProduct.PcRam;
import reading.designPatternLesson.creational.abstractFactory.factory.Factory;
import reading.designPatternLesson.creational.abstractFactory.product.Cpu;
import reading.designPatternLesson.creational.abstractFactory.product.Ram;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 11:32
 * @Modified By:
 */
public class PcFactory implements Factory {

    @Override
    public Cpu createCpu() {
        return new PcCpu();
    }

    @Override
    public Ram createRam() {
        return new PcRam();
    }
}
