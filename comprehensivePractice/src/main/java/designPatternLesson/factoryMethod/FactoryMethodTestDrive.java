package designPatternLesson.factoryMethod;

import designPatternLesson.utils.XMLUtil;

/**
 * 测试工厂方法模式的应用
 * @author jhmarryme.cn
 * @date 2019/10/13 13:55
 */
public class FactoryMethodTestDrive {

    public static void main(String[] args) throws Exception {
        LoggerFactory loggerFactory;
        Logger logger;

        //通过反射的方式获取文件日志工厂对象
        loggerFactory = (LoggerFactory) XMLUtil.getBean("config.xml", "fileLoggerFactory");
        logger = loggerFactory.createLogger();
        logger.writeLog();
    }
}
