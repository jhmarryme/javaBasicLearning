package javaBase.copy.shallow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Cloneable{
    private String name;  // 姓名
    private int age;      // 年龄
    private Major major;  // 所学专业

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}