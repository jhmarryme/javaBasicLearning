package javaBase.reflect;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.CreateUtils;

/**
 * description: 
 * @author JiaHao Wang
 * @date 2021/2/1 9:18
 */
public class ReflectUtilsTest {

    @Test
    @DisplayName("通过反射工具类直接打印对象")
    public void whenPrintObjectSuccess() {

        System.out.println(ReflectionToStringBuilder.toString(CreateUtils.createStudent(false), ToStringStyle.MULTI_LINE_STYLE));
    }
}
