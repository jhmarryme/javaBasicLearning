package imooc.javaBasic.reflect;

/**
 * @author jhmarryme.cn
 * @date 2019/7/24 19:15
 */
public class Robot {
    private String name;
    public void sayHi(String helloSentence){
        System.out.println(helloSentence + " " + name);
    }
    private String throwHello(String tag){
        return "Hello " + tag;
    }
    static {
        System.out.println("Hello Robot");
    }

}
