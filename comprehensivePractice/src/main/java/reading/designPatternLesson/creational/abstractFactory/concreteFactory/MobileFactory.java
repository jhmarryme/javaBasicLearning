package reading.designPatternLesson.creational.abstractFactory.concreteFactory;

import reading.designPatternLesson.creational.abstractFactory.concreteProduct.MobileCpu;
import reading.designPatternLesson.creational.abstractFactory.concreteProduct.MobileRam;
import reading.designPatternLesson.creational.abstractFactory.factory.Factory;
import reading.designPatternLesson.creational.abstractFactory.product.Cpu;
import reading.designPatternLesson.creational.abstractFactory.product.Ram;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 11:33
 * @Modified By:
 */
public class MobileFactory implements Factory {
    @Override
    public Cpu createCpu() {
        return new MobileCpu();
    }

    @Override
    public Ram createRam() {
        return new MobileRam();
    }
}
