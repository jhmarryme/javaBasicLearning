package chapter2;

/**
 * @author jhmarryme.cn
 * @date 2019/8/25 10:16
 */
public class Code2_SingletonPattern {
}


class Singleton{
    private static final Singleton singleton = new Singleton();
    private Singleton(){
    }

    public static Singleton getSingleton(){
        return singleton;
    }
}

class Singleton2{
    private static Singleton2 instance = null;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if (instance == null){
            synchronized(Singleton2.class){
                if (instance == null){
                    instance = new Singleton2();
                }
            }
        }

        return instance;
    }
}
