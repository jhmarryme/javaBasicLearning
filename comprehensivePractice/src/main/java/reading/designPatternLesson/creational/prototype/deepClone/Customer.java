package reading.designPatternLesson.creational.prototype.deepClone;

import lombok.Data;

import java.io.*;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 12:50
 * @Modified By:
 */
@Data
public class Customer implements Serializable {

    /** 对象必须实现Serializable接口 **/
    private Address address;

    public Customer deepClone() throws IOException, ClassNotFoundException {

        //创建输出流, 写入对象
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(this);

        //创建输入流, 获取对象

        //这里直接将字节数组输出流转换为字节数组 作为输入流的缓冲数组
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        final ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        return (Customer) inputStream.readObject();

    }
}
