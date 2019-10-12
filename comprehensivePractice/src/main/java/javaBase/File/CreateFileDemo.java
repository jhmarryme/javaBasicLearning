package javaBase.File;

import java.io.*;

/**
 * @author jhmarryme.cn
 * @date 2019/7/17 11:57
 */
public class CreateFileDemo {
    public static void main(String[] args) throws IOException {
/*
        ;
//      File f = new File("e:", "fileStream/helloWorld.java");
        File f = new File("e:", "fileStream/helloWorld.java");
        System.out.println("文件绝对路径:"+f.getAbsolutePath());
        System.out.println("文件构造路径:"+f.getPath());
        System.out.println("文件名称:"+f.getName());
        System.out.println("文件长度:"+f.length()+"字节");
*/

        /*File file = new File("e:fileStream");
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.isAbsolute() = " + file.isAbsolute());
        */
        File file = new File("D:\\", "WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File");
        System.out.println(file.isDirectory());
        if (file.isDirectory()) {
            File hello = new File(file, "hellWorld.java");
            if (!hello.exists()) {
                System.out.println(hello.exists());
                hello.createNewFile();
                System.out.println(hello.exists());
            }
        }

        for (String s : file.list()) {
            System.out.println(s);
        }
        for (File listFile : file.listFiles()) {
            System.out.println(listFile.getAbsolutePath());
        }
    }
}
