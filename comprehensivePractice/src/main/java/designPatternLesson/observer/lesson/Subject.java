package designPatternLesson.observer.lesson;

/**
 * 抽象主题
 * @author jhmarryme.cn
 * @date 2019/10/27 13:56
 */
public interface Subject {


    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(Observer observer);
}
