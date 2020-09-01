package javaBase.copy.shallow;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Major {
    private String majorName; // 专业名称
    private long majorId;     // 专业代号
    
    // ... 其他省略 ...
}