package reading.designPatternLesson.creational.abstractFactory;

import reading.designPatternLesson.creational.abstractFactory.concreteFactory.MobileFactory;
import reading.designPatternLesson.creational.abstractFactory.concreteFactory.PcFactory;
import reading.designPatternLesson.creational.abstractFactory.product.Cpu;
import reading.designPatternLesson.creational.abstractFactory.product.Ram;
import org.junit.jupiter.api.Test;

/**
 * description: 抽象工厂
 *     创建一系列相关或相互依赖的对象， 而无需指定其具体类。
 * @Author: Wjh
 * @Date: 2020/10/12 11:25
 * @Modified By:
 */
public class AbstractFactoryTest {

    @Test
    public void createProductSuccess() {
        PcFactory pcFactory = new PcFactory();
        Cpu pcCpu = pcFactory.createCpu();
        Ram pcRam = pcFactory.createRam();
        pcCpu.display();
        pcRam.display();

        MobileFactory mobileFactory = new MobileFactory();
        Cpu mobileCpu = mobileFactory.createCpu();
        Ram mobileRam = mobileFactory.createRam();
        mobileCpu.display();
        mobileRam.display();
    }
}
