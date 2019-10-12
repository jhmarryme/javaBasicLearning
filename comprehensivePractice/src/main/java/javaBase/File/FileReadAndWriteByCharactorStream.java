package javaBase.File;

import java.io.FileReader;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 15:02
 */
public class FileReadAndWriteByCharactorStream {

    public static void main(String[] args) throws Exception {

        testRead();
    }

    public static void testRead() throws Exception {

        FileReader fileReader = new FileReader("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\hellWorld.txt");

        char[] chars = new char[4];
        int len = -1;
        while ( (len = fileReader.read(chars)) != -1 ){
            System.out.print(new String(chars, 0, len));
        }
        fileReader.close();
    }
}
