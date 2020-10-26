package reading.designPatternLesson.observer.lesson2;

import java.util.Observable;

/**
 * @author jhmarryme.cn
 * @date 2019/10/28 10:42
 */
public class Ring extends Observable {

    /**
     * 响铃了,  通知学生和老师
     */
    public void ringDown(){

        System.out.println("开始打铃了...");
        setChanged();
        notifyObservers();
    }
}
