package reading.designPatternLesson.creational.factoryMethod.concreteCreator;

import reading.designPatternLesson.creational.factoryMethod.concreteProduct.Truck;
import reading.designPatternLesson.creational.factoryMethod.creator.Logistics;
import reading.designPatternLesson.creational.factoryMethod.product.Transport;

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
