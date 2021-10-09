package javaBase.checkNull;

import base.entity.Student;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.CreateUtils;

import java.lang.reflect.Field;

/**
 *
 * @author JiaHao Wang
 * @date 2021/9/26 上午10:56
 */
public class CheckNullTest {
    
    @Test
    @DisplayName("所有字段都不能为空， 包括空字符串")
    public void whenNotConludeNullFieldSuccess() {
        Student student = new Student();
        Assertions.assertFalse(checkObjAllFieldsIsNotNull(student));

        Student includeNullFieldsStu = new Student();
        includeNullFieldsStu.setAge(15);
        Assertions.assertFalse(checkObjAllFieldsIsNotNull(includeNullFieldsStu));

        Student notIncludeNullFieldsStu = CreateUtils.createStudent(false);
        Assertions.assertTrue(checkObjAllFieldsIsNotNull(notIncludeNullFieldsStu));
    }

    public boolean checkObjAllFieldsIsNotNull(Object obj) {
        if (null == obj) {
            return false;
        }

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(obj) == null || StringUtils.isBlank(field.get(obj).toString())) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
