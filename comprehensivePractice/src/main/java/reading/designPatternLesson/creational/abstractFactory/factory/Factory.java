package reading.designPatternLesson.creational.abstractFactory.factory;

import reading.designPatternLesson.creational.abstractFactory.product.Cpu;
import reading.designPatternLesson.creational.abstractFactory.product.Ram;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 11:29
 * @Modified By:
 */
public interface Factory {

    Cpu createCpu();
    Ram createRam();
}
