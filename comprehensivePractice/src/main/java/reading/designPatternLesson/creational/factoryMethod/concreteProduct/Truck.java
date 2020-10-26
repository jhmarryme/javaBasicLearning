package reading.designPatternLesson.creational.factoryMethod.concreteProduct;

import reading.designPatternLesson.creational.factoryMethod.product.Transport;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 10:38
 * @Modified By:
 */
public class Truck implements Transport {

    @Override
    public void deliver() {
        System.out.println("陆路运输");
    }
}
