package javaBase.copy.shallow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Cloneable{
    private String name;  // 姓名
    private int age;      // 年龄
    private Major major;  // 所学专业

    /**
     *  对象的浅拷贝方法, 需要实现Cloneable
     *
     * @Param: []
     * @Return: java.lang.Object
     * @Author: Wjh
     * @Since: 2020/9/1 8:58
     * @Throws
     **/
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}