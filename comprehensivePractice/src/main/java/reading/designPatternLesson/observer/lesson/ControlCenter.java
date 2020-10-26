package reading.designPatternLesson.observer.lesson;

import java.util.ArrayList;

/**
 * 具体主题类
 * @author jhmarryme.cn
 * @date 2019/10/27 13:59
 */
public class ControlCenter implements Subject {

    private ArrayList<Observer> observers;

    public ControlCenter() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver(Observer observer) {
        System.out.println("支援正在赶来...");
        observers.stream().filter(o -> !o.equals(observer)).forEach(o -> {
            o.help();
        });
    }
}
