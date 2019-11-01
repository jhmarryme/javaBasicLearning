package designPatternLesson.iterator.lesson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author jhmarryme.cn
 * @date 2019/10/27 12:53
 */
public class Class {

    List<Student> allStudents;

    public Class() {
        allStudents = new ArrayList<>();
    }

    public void addStudent(Student s){
        allStudents.add(s);
    }

    /**
     * 输出学生信息
     */
    public void printStudents(){

        System.out.println("降序排列");
        //排序 -> 降序
        Collections.sort(allStudents, (o1, o2) -> {
            return o2.getAge() - o1.getAge();
        });

        final Iterator<Student> iterator = allStudents.iterator();

        while(iterator.hasNext()){
            final Student student = iterator.next();
            System.out.println(student.toString());
        }


    }
}
