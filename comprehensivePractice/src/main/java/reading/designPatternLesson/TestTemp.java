package reading.designPatternLesson;

/**
 * @author jhmarryme.cn
 * @date 2019/11/8 19:50
 */
public class TestTemp {
    public static void main(String[] args) {
        Son.show();
    }
}

class Parent{
    static void show(){
        System.out.println("parent");
    }
}

class Son extends Parent{
    static void show(){
        System.out.println("son");
    }
}

interface Convert{
     void convert();
}
