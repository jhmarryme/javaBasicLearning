package effectiveJava._4_noninstantiable;

/**
 * description: 4. 使用私有构造方法执行非实例化
 *
 * @Author: Wjh
 * @Date: 2020/8/26 10:32
 * @Modified By:
 */
public class UtilityClass {
    // 提供私有的构造方法组织类的实例化
    private UtilityClass() {
        throw new AssertionError();
    }
}
