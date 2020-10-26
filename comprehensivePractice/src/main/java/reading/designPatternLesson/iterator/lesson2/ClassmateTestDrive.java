package reading.designPatternLesson.iterator.lesson2;

import reading.designPatternLesson.iterator.lesson.Student;

import java.util.Iterator;

/**
 * @author jhmarryme.cn
 * @date 2019/10/28 11:03
 */
public class ClassmateTestDrive {
    public static void main(String[] args) {
        Classmate classmate = new Classmate();
        classmate.addStudent(new Student(1, "1号", 22, "男"));
        classmate.addStudent(new Student(2, "2号", 34, "女"));
        classmate.addStudent(new Student(3, "3号", 44, "女"));
        classmate.addStudent(new Student(4, "4号", 46, "男"));


        System.out.println("使用迭代器打印所有男生信息");
        final Iterator manIterator = classmate.getManIterator();
        while (manIterator.hasNext()){
            System.out.println(manIterator.next().toString());
        }

        System.out.println();

        System.out.println("使用迭代器打印所有女生信息");
        final Iterator womanIterator = classmate.getWomanIterator();
        while (womanIterator.hasNext()){
            System.out.println(womanIterator.next().toString());
        }
    }
}
