package designPatternLesson.creational.factoryMethod;

import designPatternLesson.creational.factoryMethod.concreteCreator.RoadLogistics;
import designPatternLesson.creational.factoryMethod.concreteCreator.SealLogistics;
import designPatternLesson.creational.factoryMethod.creator.Logistics;
import org.junit.jupiter.api.Test;

/**
 * description: 工厂方法
 *     在父类中提供一个创建对象的方法， 允许子类决定实例化对象的类型。
 * @Author: Wjh
 * @Date: 2020/10/12 10:38
 * @Modified By:
 */
public class FactoryMethodTest {

    @Test
    public void whenCreateTransportSuccess() {
        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery();

        Logistics sealLogistics = new SealLogistics();
        sealLogistics.planDelivery();
    }
}
