package designPatternLesson.abstractFactory;

import designPatternLesson.utils.XMLUtil;

/**
 * 测试抽象工厂模式的应用
 * @author jhmarryme.cn
 * @date 2019/10/13 18:50
 */

public class AbstractFactoryTestDrive {

    public static void main(String[] args) throws Exception {

        //通过配置文件获取工厂对象
        PcFactory pcFactory = (PcFactory) XMLUtil.getBean("config.xml", "pcFactory");
        pcFactory.getCPU().display();
        pcFactory.getRAM().display();

        MacFactory macFactory = (MacFactory) XMLUtil.getBean("config.xml", "macFactory");
        macFactory.getCPU().display();
        macFactory.getRAM().display();

    }

}


















