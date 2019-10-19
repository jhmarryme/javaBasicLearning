package designPatternLesson.factoryMethod;

/**
 * 具体产品
 * @author jhmarryme.cn
 * @date 2019/10/13 13:50
 */
public class DataBaseLogger implements Logger{
    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }
}
