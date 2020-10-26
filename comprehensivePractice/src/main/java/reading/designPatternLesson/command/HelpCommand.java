package reading.designPatternLesson.command;

/**
 * 具体命令类
 * @author jhmarryme.cn
 * @date 2019/10/17 10:48
 */
public class HelpCommand implements Command {

    //对请求接受者的引用
    private DisplayHelpClass helpClass;

    public HelpCommand() {
        helpClass = new DisplayHelpClass();
    }

    /**
     * 对具体业务的调用
     */
    @Override
    public void execute() {
        helpClass.display();
    }
}
