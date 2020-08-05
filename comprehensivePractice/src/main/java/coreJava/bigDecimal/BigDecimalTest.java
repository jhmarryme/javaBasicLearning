package coreJava.bigDecimal;

import java.math.BigDecimal;

/**
 * @program: core-java
 * @description:
 * @author: JiaHao Wang
 * @create: 2020-06-19 14:51
 **/
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal decimal = BigDecimal.valueOf(11);

        // 如果商为无限循环小数, 则需要添加第二个RoundingMode参数, 否则会出现异常.
        // ROUND_HALF_UP代表四舍五入
        BigDecimal divide = decimal.divide(BigDecimal.valueOf(3), BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
    }
}
