package reading.designPatternLesson.creational.factoryMethod.creator;

import reading.designPatternLesson.creational.factoryMethod.product.Transport;

/**
 * description:
 * @Author: Wjh
 * @Date: 2020/10/12 10:40
 * @Modified By:
 */
public abstract class Logistics {

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }

    public abstract Transport createTransport();
}
