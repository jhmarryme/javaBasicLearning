package reading.designPatternLesson.creational.factoryMethod.concreteCreator;

import reading.designPatternLesson.creational.factoryMethod.concreteProduct.Ship;
import reading.designPatternLesson.creational.factoryMethod.creator.Logistics;
import reading.designPatternLesson.creational.factoryMethod.product.Transport;

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
