package designPatternLesson.command;

/**
 * 请求的调用者
 * @author jhmarryme.cn
 * @date 2019/10/17 10:49
 */
public class FunctionButton {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click(){
        System.out.println("单击功能键");
        command.execute();
    }
}
