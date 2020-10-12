package designPatternLesson.creational.factoryMethod.concreteProduct;

import designPatternLesson.creational.factoryMethod.product.Transport;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 10:39
 * @Modified By:
 */
public class Ship implements Transport {

    @Override
    public void deliver() {
        System.out.println("海路运输");
    }
}
