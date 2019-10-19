package designPatternLesson.factoryMethod;

/**
 * 具体工厂
 * @author jhmarryme.cn
 * @date 2019/10/13 13:54
 */
public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        // 创建具体对象
        Logger logger = new FileLogger();
        return logger;
    }
}
