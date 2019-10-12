package javaBase.File;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 15:56
 */
public class FileReadAndWriteByConversionStream {

    public static void main(String[] args) {

        testRead();
    }
    /**
     * 读取GB2312格式的文件
     */
    public static void testRead(){

        try (
//                FileReader reader = new FileReader("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\test.txt");
                InputStreamReader reader = new InputStreamReader(
                        new FileInputStream("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\test.txt"), "GB2312"
                );
        ){
            int read;
            while ((read = reader.read()) != -1){
                System.out.print((char)read);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
