package reading.designPatternLesson.command;

/**
 * 具体命令类 (收到命令后, 完成指定的调用)
 * @author jhmarryme.cn
 * @date 2019/10/17 10:44
 */
public class ExitCommand implements Command {

    // 请求接受者的对象引用
    private SystemExitClass exitClass;

    public ExitCommand( ) {
        this.exitClass = new SystemExitClass();
    }

    /**
     * 调用请求接受者的业务方法
     */
    @Override
    public void execute() {
        exitClass.exit();
    }
}
