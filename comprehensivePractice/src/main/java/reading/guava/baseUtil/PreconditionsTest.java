package reading.guava.baseUtil;

import base.entity.Student;
import com.google.common.base.Preconditions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.CreateUtils;

import java.util.Date;

/**
 * description: 前置条件
 *
 *  https://wizardforcel.gitbooks.io/guava-tutorial/content/4.html
 * @Author: Wjh
 * @Date: 2020/10/13 10:15
 * @Modified By:
 */
public class PreconditionsTest {

    @Test
    public void preconditionsTest() {
        // 检测参数
        boolean received = receiveParameters(CreateUtils.createStudent(false));
        Assertions.assertTrue(received);

        Assertions.assertFalse(receiveParameters(null));

        System.out.println(new Date().toString());
    }


    public static boolean receiveParameters(Student student) {
        try {
            // failed -> NullPointerException
            Student stu = Preconditions.checkNotNull(student);
        } catch (Exception e) {
            return false;
        }
        System.out.println(student.toString());
        return true;
    }
}
