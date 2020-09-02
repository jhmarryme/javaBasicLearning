package base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: core-java
 * @description:
 * @author: JiaHao Wang
 * @create: 2020-07-01 16:31
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private int age;
    private int gender;
    private String phone;
    private String address;
    private String test;
    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public User setList(List<String> list) {
        this.list = list;
        return this;
    }

}
