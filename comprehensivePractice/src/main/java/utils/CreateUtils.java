package utils;

import base.entity.Student;
import base.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/2 12:14
 * @Modified By:
 */
public class CreateUtils {

    /**
     *  返回一个Student对象
     *
     * @Param: [isEmpty] 是否为空
     * @Return: base.entity.Student
     * @Author: Wjh
     * @Since: 2020/9/2 12:15
     **/
    public static Student createStudent(boolean isEmpty) {
        new Student();
        return isEmpty ? new Student() : Student.builder().age(24).id(4).name("wjh").sex("男").build();
    }


    /**
     *  生成简单的List<User>
     *
     * @Param: [hasEmpty] 是否需要空的user
     * @Return: java.util.List<base.entity.User>
     * @Author: Wjh
     * @Since: 2020/9/2 13:04
     **/
    public static List<User> createUserList(boolean hasEmpty) {
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setUserId(i);
            user.setUserName(String.format("%s 号", i));
            user.setAge(random.nextInt(100));
            user.setGender(i % 2);
            user.setPhone("18812021111" + i);
            user.setAddress("无" + i);
            if (i % 2 == 0) {
                user.setTest("test" + i);
                List<String> list = user.getList();
                list.add("a" + i);
                list.add("b" + i);
                user.setList(list);
            }
            if (i % 5 == 0) {
                user = hasEmpty ? null : user;
            }
            users.add(user);
        }
        return users;
    }
}
