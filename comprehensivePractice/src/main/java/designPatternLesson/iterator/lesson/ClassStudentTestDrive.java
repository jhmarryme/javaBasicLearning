package designPatternLesson.iterator.lesson;

/**
 * @author jhmarryme.cn
 * @date 2019/10/27 13:11
 */
public class ClassStudentTestDrive {
    public static void main(String[] args) {


        Class c = new Class();
        c.addStudent(new Student(1, "1号", 22, "男"));
        c.addStudent(new Student(2, "2号", 34, "男"));
        c.addStudent(new Student(3, "3号", 44, "女"));
        c.addStudent(new Student(4, "4号", 46, "男"));

        c.printStudents();
    }
}
