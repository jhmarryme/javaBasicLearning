package reading.imooc.javaBasic.jvm.gc;

/**
 * @author jhmarryme.cn
 * @date 2019/9/18 17:23
 */
public class Finalization {

    public static Finalization finalization;
    @Override
    protected void finalize() throws Throwable {

        System.out.println("finalized");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization f = new Finalization();

        System.out.println("first: " + f);
        f = null;
        System.gc();
        try {
            Thread.currentThread().sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("second : " + f);
        System.out.println(f.finalization);
    }
}


