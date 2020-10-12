package designPatternLesson.creational.builder.product;

import lombok.Data;
import lombok.ToString;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 12:16
 * @Modified By:
 */
@Data
@ToString
public class Actor {
    /** 角色类型 **/
    private String type;
    
    /** 性别 **/
    private String sex;
    
    /** 服装 **/
    private String costume;
}
