package reading.imooc.javaBasic.reflect;

/**
 * 测试自定义类加载器
 * @author jhmarryme.cn
 * @date 2019/7/24 20:23
 */
public class MyClassLoaderChecker {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyClassLoader classLoader = new MyClassLoader("D:/develop/folderForDevelop/", "myClassLoader");
        //调用的是loadClass方法加载类
        Class<?> waLi = classLoader.loadClass("WaLi");
        System.out.println(waLi.getClassLoader());
        waLi.newInstance();
    }
}
