package designPatternLesson.creational.prototype;

import designPatternLesson.creational.prototype.deepClone.Address;
import designPatternLesson.creational.prototype.deepClone.Customer;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 12:48
 * @Modified By:
 */
public class PrototypeTest {

    @SneakyThrows
    @Test
    public void whenPrototypeCloneSuccess() {

        //通过深克隆实现
        final Customer customer = new Customer();
        customer.setAddress(new Address());
        final Customer customerCopy = customer.deepClone();
        //打印结果
        System.out.println("深克隆结果: ");
        System.out.println("customer == customerCopy   " + (customer == customerCopy));
        System.out.println("customer.getAddress() == customerCopy.getAddress()   " + (customer.getAddress() == customerCopy.getAddress()));


        //通过浅克隆实现
        final designPatternLesson.creational.prototype.shallowClone.Customer
                shallowCustomer = new designPatternLesson.creational.prototype.shallowClone.Customer();
        shallowCustomer.setAddress(new designPatternLesson.creational.prototype.shallowClone.Address());
        final designPatternLesson.creational.prototype.shallowClone.Customer
                shallowCustomerCopy = shallowCustomer.clone();

        System.out.println("浅克隆结果: ");
        System.out.println("shallowCustomer == shallowCustomerCopy   " + (shallowCustomer == shallowCustomerCopy));
        System.out.println("shallowCustomer.getAddress() == shallowCustomerCopy.getAddress()   " +
                (shallowCustomer.getAddress() == shallowCustomerCopy.getAddress()));
    }
}
