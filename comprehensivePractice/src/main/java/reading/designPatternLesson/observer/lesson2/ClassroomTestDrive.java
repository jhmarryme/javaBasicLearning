package reading.designPatternLesson.observer.lesson2;

/**
 * @author jhmarryme.cn
 * @date 2019/10/28 10:50
 */
public class ClassroomTestDrive {

    public static void main(String[] args) {
        final Ring ring = new Ring();

        final Student student = new Student(ring);
        final Teacher teacher = new Teacher(ring);

        //开始通知
        ring.ringDown();
    }
}
