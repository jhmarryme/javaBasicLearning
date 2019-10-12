package javaBase;

/**
 * @author jhmarryme.cn
 * @date 2019/7/1 9:53
 */


class T{
    public void show(){
        System.out.println("a.show()");
    }
}
class F extends T{
    @Override
    public void show() {
        System.out.println("b.show()");
    }
    public void showF(){
        System.out.println("F");
    }
}

public class Test2 {
    public static void main(String[] args) {
        T t = new F();
        t.show();
    }
}
