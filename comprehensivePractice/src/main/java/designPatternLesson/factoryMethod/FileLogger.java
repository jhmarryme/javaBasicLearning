package designPatternLesson.factoryMethod;

/**
 * 具体产品
 * @author jhmarryme.cn
 * @date 2019/10/13 13:51
 */
public class FileLogger implements Logger {
    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}
