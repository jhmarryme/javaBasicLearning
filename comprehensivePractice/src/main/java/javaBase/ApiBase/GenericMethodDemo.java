package javaBase.ApiBase;

public class GenericMethodDemo {
    public static void main(String[] args) {
        // 创建对象
        MyGenericMethod mm = new MyGenericMethod();
        // 演示看方法提示
        mm.show2("aaa");
        mm.show2(123);
        System.out.println(mm.show2(12.45));;
    }
}