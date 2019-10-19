package designPatternLesson.protoType;

import java.io.IOException;

/**
 * 通过比较深/浅克隆实现原型模式
 * @author jhmarryme.cn
 * @date 2019/10/13 19:36
 */
public class CustomerProtoTypeTestDrive {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        //通过深克隆实现
        final CustomerForDeepClone customer = new CustomerForDeepClone();
        customer.setAddress(new AddressForDeepClone());
        final CustomerForDeepClone customerCopy = customer.deepClone();
        //打印结果
        System.out.println("深克隆结果: ");
        System.out.println("customer == customerCopy   " + (customer == customerCopy));
        System.out.println("customer.getAddress() == customerCopy.getAddress()   " + (customer.getAddress() == customerCopy.getAddress()));


        //通过浅克隆实现
        final CustomerForShallowCLone shallowCustomer = new CustomerForShallowCLone();
        shallowCustomer.setAddress(new AddressForShallowClone());
        final CustomerForShallowCLone shallowCustomerCopy = shallowCustomer.clone();

        System.out.println("浅克隆结果: ");
        System.out.println("shallowCustomer == shallowCustomerCopy   " + (shallowCustomer == shallowCustomerCopy));
        System.out.println("shallowCustomer.getAddress() == shallowCustomerCopy.getAddress()   " +
                (shallowCustomer.getAddress() == shallowCustomerCopy.getAddress()));

    }
}
