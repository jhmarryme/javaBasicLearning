package javaBase.copy;

import javaBase.copy.create.Major;
import javaBase.copy.create.Student;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/8/27 10:52
 * @Modified By:
 */
public class ObjectCopyExample {
    @SneakyThrows
    @Test
    public void shallowCopy() {
        Major major = new Major("jhmarryme", 0L);
        Student student = new Student("wjh", 11, major);

        // 进行浅拷贝
        Student student1 = (Student) student.clone();

        System.out.println("(student == student1) = " + (student == student1));
        System.out.println("student = " + student);
        System.out.println("student1 = " + student1);

        major.setMajorId(1);
        major.setMajorName("wjh");

        System.out.println("student = " + student);
        System.out.println("student1 = " + student1);
    }


    @SneakyThrows
    @Test
    public void deepCopy() {

    }
}
