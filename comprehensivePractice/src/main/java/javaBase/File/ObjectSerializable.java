package javaBase.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 16:24
 */
public class ObjectSerializable {

    public static void main(String[] args) {

        testSerializable();
        testDeserializable();
    }

    /**
     * 反序列化对象
     */
    public static void testDeserializable(){
        Employee employee = null;

        try (
                final ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\employee.txt"));
        ){
            employee = (Employee) inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(employee.getAge());
    }


    /**
     * 序列化对象
     */
    public static void testSerializable(){
        Employee employee = new Employee();
        employee.setAge(23);
        employee.setName("王豪");
        employee.setAddress("荣昌");

        try (
                //序列化流对象
                final ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\employee.txt"));
        ){
            outputStream.writeObject(employee);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
