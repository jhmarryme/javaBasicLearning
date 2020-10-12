package designPatternLesson.creational.abstractFactory.concreteFactory;

import designPatternLesson.creational.abstractFactory.concreteProduct.PcCpu;
import designPatternLesson.creational.abstractFactory.concreteProduct.PcRam;
import designPatternLesson.creational.abstractFactory.factory.Factory;
import designPatternLesson.creational.abstractFactory.product.Cpu;
import designPatternLesson.creational.abstractFactory.product.Ram;

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
