package javaBase.functionalProgram.functional.DelayForLambda;

/**
 * @author jhmarryme.cn
 * @date 2019/7/22 9:33
 */

@FunctionalInterface
public interface MessageBuilder {

    int MAX_NUM = 97;
    /**
     * 测试lambda延迟加载
     * @return
     */
    String messageBuilder();
}
