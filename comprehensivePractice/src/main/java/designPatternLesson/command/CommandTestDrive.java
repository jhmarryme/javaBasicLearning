package designPatternLesson.command;

import designPatternLesson.utils.XMLUtil;

/**
 * @author jhmarryme.cn
 * @date 2019/10/17 10:54
 */
public class CommandTestDrive {

    public static void main(String[] args) throws Exception {

        FunctionButton button = new FunctionButton();
        final Command bean = (Command) XMLUtil.getBean("config.xml", "commandClassName");

        button.setCommand(bean);
        button.click();
    }
}
