package dataType;

/**
 * @author jhmarryme.cn
 * @date 2019/6/23 9:55
 */
public interface InterfaceTest {
    default void method1(){
        System.out.println("method1");
    }
    default void method2(){
        System.out.println("method2");
    }
}

abstract class AbstractTest implements InterfaceTest{

}
class ClassTest extends AbstractTest{

}
