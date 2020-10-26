package reading.designPatternLesson.observer.lesson2;


import java.util.Observable;
import java.util.Observer;

/**
 * @author jhmarryme.cn
 * @date 2019/10/28 10:43
 */
public class Student implements Observer {

    Observable observable;

    //将自己添加到观察者列表中
    public Student(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Ring){
            System.out.println("学生听到响铃了, 正在走进教室");        }
    }
}
