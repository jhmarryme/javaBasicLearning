package reading.designPatternLesson.creational.abstractFactory.concreteProduct;

import reading.designPatternLesson.creational.abstractFactory.product.Cpu;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 11:28
 * @Modified By:
 */
public class PcCpu implements Cpu {
    @Override
    public void display() {
        System.out.println("pc cpu");
    }
}
