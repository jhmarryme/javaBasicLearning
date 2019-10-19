package designPatternLesson.protoType;


import java.io.*;

/**
 * 为深克隆准备的对象
 * @author jhmarryme.cn
 * @date 2019/10/13 19:29
 */

public class CustomerForDeepClone implements Serializable {


    AddressForDeepClone address;

    public AddressForDeepClone getAddress() {
        return address;
    }

    public void setAddress(AddressForDeepClone address) {
        this.address = address;
    }

    public CustomerForDeepClone deepClone() throws IOException, ClassNotFoundException {

        //创建输出流, 写入对象
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
        outputStream.writeObject(this);

        //创建输入流, 获取对象

        //这里直接将字节数组输出流转换为字节数组 作为输入流的缓冲数组
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        final ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
        return (CustomerForDeepClone) inputStream.readObject();

    }
}
