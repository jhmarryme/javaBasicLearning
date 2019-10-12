package javaBase.enumBase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author jhmarryme.cn
 * @date 2019/7/4 19:40
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EnumTest {

    //test
    VALID_NAME(400, "wjh"),

    ;

    private int id;
    private String name;
}
