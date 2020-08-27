package coreJava.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: core-java
 * @description:
 * @author: JiaHao Wang
 * @create: 2020-07-01 16:31
 **/
public class User {
    private int userId;
    private String userName;
    private int age;
    private int gender;
    private String phone;
    private String address;
    private String test;

    private List<String> list = new ArrayList<>();

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getTest() {
        return test;
    }

    public User setTest(String test) {
        this.test = test;
        return this;
    }

    public List<String> getList() {
        return list;
    }

    public User setList(List<String> list) {
        this.list = list;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", test='" + test + '\'' +
                ", list=" + list +
                '}';
    }
}
