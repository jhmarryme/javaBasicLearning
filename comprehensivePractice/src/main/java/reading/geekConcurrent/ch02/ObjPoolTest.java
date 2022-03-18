package reading.geekConcurrent.ch02;

import base.entity.Student;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.CreateUtils;

/**
 * Semaphore 测试
 * @author JiaHao Wang
 * @date 2022/3/18 下午2:01
 */
public class ObjPoolTest {
    @Test
    @DisplayName("模拟取出一个资源池的资源并使用")
    public void whenSuccess() {
        Student stu = CreateUtils.createStudent(false);
        // 初始化资源池
        ObjPool<Student, String> pool = new ObjPool<>(2, stu);
        // 模拟取出一个资源池的资源并使用, 可以使用多线程测一下, 只会有最多两个线程同时拿到资源
        String res = pool.exec(student -> {
            ReflectionToStringBuilder.toString(student, ToStringStyle.MULTI_LINE_STYLE);
            student.setAge(student.getAge() + 1);
            return String.valueOf(student.getAge());
        });
        System.out.println(res);
    }
}
