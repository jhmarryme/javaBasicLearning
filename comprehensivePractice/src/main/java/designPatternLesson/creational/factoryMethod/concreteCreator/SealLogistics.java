package designPatternLesson.creational.factoryMethod.concreteCreator;

import designPatternLesson.creational.factoryMethod.concreteProduct.Ship;
import designPatternLesson.creational.factoryMethod.creator.Logistics;
import designPatternLesson.creational.factoryMethod.product.Transport;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 10:43
 * @Modified By:
 */
public class SealLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
