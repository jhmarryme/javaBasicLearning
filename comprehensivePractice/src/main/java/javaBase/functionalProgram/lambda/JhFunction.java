package javaBase.functionalProgram.lambda;

/**
 * @author jhmarryme
 * @date 2020/6/29 17:00
 */
public interface JhFunction<T, R, S> {

    R run(T t, S s);
}
