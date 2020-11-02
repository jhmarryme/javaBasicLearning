package reading.guava.baseutil;

import base.entity.ComplexPerson;
import com.google.common.base.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/11/2 10:45
 * @Modified By:
 */
public class AvoidNullTest {


    @Test
    @DisplayName("guava Optional 处理null值的使用")
    public void whenUseOptionalSuccess() {

        BigDecimal money = Optional.fromNullable(new ComplexPerson().getMoney()).or(new BigDecimal(0));

        assertEquals(new BigDecimal(0), money);

        assertThrows(
                NullPointerException.class,
                () -> {
                    String str = Optional.fromNullable(new ComplexPerson().getStudent().getName()).or("wjh");
                    System.out.println(str);
                },
                "fromNullable不接受多重嵌套的null对象");
    }
}
