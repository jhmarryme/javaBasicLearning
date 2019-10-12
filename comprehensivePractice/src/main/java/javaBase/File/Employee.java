package javaBase.File;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 8915532794959050340L;
    public String name;
    public String address;
    public transient int age; // transient瞬态修饰成员,不会被序列化
    public void addressCheck() {
      	System.out.println("Address  check : " + name + " -- " + address);
    }
}