package reading.designPatternLesson.creational.abstractFactory.concreteProduct;

import reading.designPatternLesson.creational.abstractFactory.product.Ram;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 11:31
 * @Modified By:
 */
public class PcRam implements Ram {
    @Override
    public void display() {
        System.out.println("pc ram");
    }
}
