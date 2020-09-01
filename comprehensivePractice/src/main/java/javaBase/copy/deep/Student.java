package javaBase.copy.deep;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

@Data
@AllArgsConstructor
public class Student implements Cloneable{
    private String name;  // 姓名
    private int age;      // 年龄
    private Major major;  // 所学专业

    /**
     *  对象的深拷贝
     *
     * @Param: []
     * @Return: javaBase.copy.deep.Student
     * @Author: Wjh
     * @Since: 2020/9/1 8:47
     * @Throws
     **/
    public Student clone() {
        try {
            // 将对象本身序列化到字节流
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream( byteArrayOutputStream );
            objectOutputStream.writeObject( this );

            // 再将字节流通过反序列化方式得到对象副本
            ObjectInputStream objectInputStream =
                    new ObjectInputStream( new ByteArrayInputStream( byteArrayOutputStream.toByteArray() ) );
            return (Student) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}