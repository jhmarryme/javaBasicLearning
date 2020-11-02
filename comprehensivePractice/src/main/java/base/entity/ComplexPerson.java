package base.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/11/2 10:51
 * @Modified By:
 */
@Data
@ToString
public class ComplexPerson extends Person {

    private Integer id;

    private Student student;

    private BigDecimal money;
}
