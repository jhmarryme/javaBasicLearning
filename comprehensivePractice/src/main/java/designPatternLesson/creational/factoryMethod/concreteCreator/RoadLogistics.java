package designPatternLesson.creational.factoryMethod.concreteCreator;

import designPatternLesson.creational.factoryMethod.concreteProduct.Truck;
import designPatternLesson.creational.factoryMethod.creator.Logistics;
import designPatternLesson.creational.factoryMethod.product.Transport;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 10:42
 * @Modified By:
 */
public class RoadLogistics extends Logistics {

    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
