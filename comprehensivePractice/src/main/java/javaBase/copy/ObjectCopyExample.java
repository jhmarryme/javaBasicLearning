package javaBase.copy;

import javaBase.copy.shallow.Major;
import javaBase.copy.shallow.Student;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * description: 深拷贝、浅拷贝
 * 基本类型一般采取的则是值传递的方式
 * 数组、类Class、枚举Enum、Integer包装类等等，是引用类型，操作时一般采用的是引用传递的方式；
 * 值类型的字段会复制一份，而引用类型的字段拷贝的仅仅是引用地址
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

        System.out.println("浅拷贝: \n");
        System.out.println("(student == student1) = " + (student == student1));
        System.out.println("student = " + student);
        System.out.println("student1 = " + student1);

        major.setMajorId(1);
        major.setMajorName("wjh");

        // majorName=wjh, majorId=1
        System.out.println("student = " + student);
        // majorName=wjh, majorId=1
        System.out.println("student1 = " + student1);
    }


    @SneakyThrows
    @Test
    public void deepCopy() {
        javaBase.copy.deep.Major major = new javaBase.copy.deep.Major("jhmarryme", 0L);
        javaBase.copy.deep.Student student = new javaBase.copy.deep.Student("wjh", 11, major);

        // 进行浅拷贝
        javaBase.copy.deep.Student student1 = student.clone();

        System.out.println("深拷贝: \n");

        System.out.println("(student == student1) = " + (student == student1));
        System.out.println("student = " + student);
        System.out.println("student1 = " + student1);

        major.setMajorId(1);
        major.setMajorName("wjh");

        // majorName=wjh, majorId=1
        System.out.println("student = " + student);
        // majorName=jhmarryme, majorId=0
        System.out.println("student1 = " + student1);
    }
}
