package designPatternLesson.creational.abstractFactory.concreteProduct;

import designPatternLesson.creational.abstractFactory.product.Ram;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 11:32
 * @Modified By:
 */
public class MobileRam implements Ram {
    @Override
    public void display() {
        System.out.println("mobile ram");
    }
}
