package javaBase.File;


import java.io.*;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 13:46
 */
public class FileReadAndWriteByByteStream {
    public static void main(String[] args) throws IOException {

        testFileWrite();

//        testReadFile();
//        testCopyFile();
    }


    public static void testReadFile(){
        File file = new File("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\hellWorld.txt");

        try {
            FileInputStream inputStream = new FileInputStream(file);
            int read;

/*
            //无参read 返回的是int类型的数据, 转换为char可以显示
            while( (read = inputStream.read()) != -1 ){
                System.out.print( ( char)read);
            }
*/



            //用byte数组作为read的参数时, 返回的是读取的长度
            byte[] bytes = new byte[2];

            while ((read = inputStream.read(bytes) ) != -1){

                System.out.print(new String(bytes,0, read));
            }

            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 文件写入
     */
    public static void testFileWrite(){
        File file = new File("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\hellWorld.txt");

        if (!file.isDirectory()) {
            System.out.println(file.getAbsolutePath());
            try {
                //为true代表追加写入, 为false或不写则清空文件
                FileOutputStream outputStream = new FileOutputStream(file,true);
                outputStream.write("helloWorld".getBytes());
                outputStream.write("\r\n".getBytes());
                outputStream.write(97);

                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }


    /**
     * 测试复制文件
     */
    public static void testCopyFile() throws IOException {

        //打开源文件
        FileInputStream source = new FileInputStream("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\hellWorld.txt");
        //打开目标文件, 不存在
        FileOutputStream target = new FileOutputStream("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\hellWorld-back.txt");

        //指定缓冲数组大小
        byte[] b = new byte[1024];
        int len = -1;

        while ( (len = source.read(b)) != -1 ){
            target.write(b, 0, len);
        }

        source.close();
        target.close();
    }
}
