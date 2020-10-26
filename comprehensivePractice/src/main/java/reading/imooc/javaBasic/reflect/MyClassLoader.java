package reading.imooc.javaBasic.reflect;

import java.io.*;

/**
 * 自定义的类加载器, 用于加载自定义位置的类
 * 通过重写findClass方法 达到效果
 * 重写的是findClass方法, 但使用时调用的是loadClass方法
 * @author jhmarryme.cn
 * @date 2019/7/24 20:14
 */
public class MyClassLoader extends ClassLoader {
    //类所在的路径
    private String path;
    //随意取名
    private String classLoaderName;

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    /**
     * 用于寻找类文件
     * @param name
     * @return
     */
    @Override
    public Class findClass(String name){
        //先加载类的二进制流
        byte[] b = loadClassData(name);
        //通过defineClass方法创建类
        return defineClass(name, b, 0, b.length);
    }

    //用于加载类文件
    private byte[] loadClassData(String name) {

        //找到类文件
        name = path + "/" + name + ".class";

        try (
                InputStream in = new FileInputStream(new File(name));
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                ){

            int i = 0;
            while ((i = in.read()) != -1){
                out.write(i);
            }
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
