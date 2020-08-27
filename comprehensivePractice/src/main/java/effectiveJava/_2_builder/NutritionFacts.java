package effectiveJava._2_builder;

import lombok.*;

/*
 * Description: 2.当构造方法参数过多时使用 builder 模式
 *  这里使用lombok的注解实现
 * @Author: Wjh
 * @Date: 2020/8/26 10:33
 * Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NutritionFacts {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;
}