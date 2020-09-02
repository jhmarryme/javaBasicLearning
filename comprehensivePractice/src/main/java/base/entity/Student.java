package base.entity;

import lombok.*;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/2 11:24
 * @Modified By:
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    private Integer id;

    private String name;

    private Integer age;

    private String sex;
}
