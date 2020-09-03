package coreJava.lambda.onjava8;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/3 17:57
 * @Modified By:
 */
public class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}
