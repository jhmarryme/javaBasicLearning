package coreJava.functional.functionalInterface.multiParameter;

/**
 * description: 三参数函数的接口
 *
 * @Author: Wjh
 * @Date: 2020/9/8 11:24
 * @Modified By:
 */
@FunctionalInterface
public interface TriFunction<T, U, V ,R> {
    R apply(T t, U u, V v);
}
