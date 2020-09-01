package javaBase.copy.deep;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/1 8:43
 * @Modified By:
 */
@AllArgsConstructor
@Data
public class Major implements Serializable {
    private static final long serialVersionUID = -189841902559819400L;
    private String majorName; // 专业名称
    private long majorId;     // 专业代号
}
