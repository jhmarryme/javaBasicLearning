package designPatternLesson.observer.lesson;

import java.util.Objects;

/**
 * 具体观察者
 * @author jhmarryme.cn
 * @date 2019/10/27 13:54
 */
public class Player implements Observer {

    private String name;
    //维持一个控制中心的引用
    Subject subject;
    public Player(String name, Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println(this.name + "前来支援");
    }

    @Override
    public void seekHelp() {
        System.out.println(this.name + "正在寻求帮助");
        subject.notifyObserver(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
