package reading.designPatternLesson.iterator.lesson2;

import reading.designPatternLesson.iterator.lesson.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jhmarryme.cn
 * @date 2019/10/28 10:58
 */
public class Classmate {

    List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student){
        studentList.add(student);
    }
    public void removeStudent(Student student){
        studentList.remove(student);
    }

    public Iterator getManIterator(){

        //通过stream流 过滤出性别为男的学生, 返回它的迭代器
        return studentList.stream().filter(student -> {
            return student.getSex().equalsIgnoreCase("男");
        }).iterator();
    }

    public Iterator getWomanIterator(){

        //通过stream流 过滤出性别为男的学生, 返回它的迭代器
        return studentList.stream().filter(student -> {
            return student.getSex().equalsIgnoreCase("女");
        }).iterator();
    }
}
