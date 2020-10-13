package reading.guava.baseUtil;

import base.entity.Student;
import com.google.common.base.Preconditions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.CreateUtils;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/13 10:15
 * @Modified By:
 */
public class PreconditionsTest {

    @Test
    public void preconditionsTest() {
        boolean received = receiveParameters(CreateUtils.createStudent(true));
        Assertions.assertTrue(received);

    }


    public static boolean receiveParameters(Student student) {
        // failed -> NullPointerException
        Student stu = Preconditions.checkNotNull(student);
        return true;
    }
}
