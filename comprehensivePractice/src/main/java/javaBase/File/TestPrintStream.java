package javaBase.File;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 16:41
 */
public class TestPrintStream {
    public static void main(String[] args) throws Exception {

        final PrintStream printStream = new PrintStream("D:\\WJH-workSpace\\code\\java\\new\\reading\\cyc2018\\src\\main\\java\\javaBase\\File\\test.txt");
        System.setOut(printStream);
        System.out.println("hello");
    }
}
