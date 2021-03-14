package base.entity.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description: 
 * @author JiaHao Wang
 * @date 2021/2/28 18:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Son extends Person{
    private List<String> kids;
}
