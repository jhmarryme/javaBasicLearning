package designPatternLesson.observer.lesson;

/**
 * @author jhmarryme.cn
 * @date 2019/10/27 14:11
 */
public class ObserverTestDrive {
    public static void main(String[] args) {
        //注册一个控制中心
        Subject subject = new ControlCenter();
        //创建角色
        Observer player1 = new Player("盖伦", subject);
        Observer player2 = new Player("哈撒给", subject);
        Observer player3 = new Player("赵信", subject);
        Observer player4 = new Player("易大师", subject);

        //盖伦请求支援
        player1.seekHelp();
    }
}
