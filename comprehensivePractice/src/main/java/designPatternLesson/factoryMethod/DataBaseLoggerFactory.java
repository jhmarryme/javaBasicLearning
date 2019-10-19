package designPatternLesson.factoryMethod;

/**
 * 具体工厂
 * @author jhmarryme.cn
 * @date 2019/10/13 13:52
 */
public class DataBaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        //创建数据库日志对象
        Logger logger = new DataBaseLogger();
        return logger;
    }
}
