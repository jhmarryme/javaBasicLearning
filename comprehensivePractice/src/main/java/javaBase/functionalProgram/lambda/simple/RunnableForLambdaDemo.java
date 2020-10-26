package javaBase.functionalProgram.lambda.simple;

/**
 * @author jhmarryme.cn
 * @date 2019/7/17 11:15
 */
public class RunnableForLambdaDemo {
    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("lambdaThread Started");
        }).start();
    }
}
