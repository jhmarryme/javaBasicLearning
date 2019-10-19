package designPatternLesson.factoryMethod;

/**
 * 抽象工厂
 * @author jhmarryme.cn
 * @date 2019/10/13 13:52
 */
public interface LoggerFactory {
    Logger createLogger();
}


/*public abstract class LoggerFactory {

 *//**
 * 隐藏工厂方法, 直接使用工厂对象即可调用创建的产品中的业务方法
 *//*
    public void writeLog(){
        Logger logger = this.createLogger();
        logger.writeLog();
    }

    public abstract Logger createLogger();
}*/
