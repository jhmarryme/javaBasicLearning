package chapter2;

/**
 * @author jhmarryme.cn
 * @date 2019/6/20 19:07
 */
public interface Subject {
    /**
     * 注册观察者
     * @param o
     */
    public void registerObserver(Observer o);

    /**
     * 移除观察者
     * @param o
     */
    public void removeObserver(Observer o);

    /**
     * 通知所有观察者
     */
    public void notifyObserves();
}

