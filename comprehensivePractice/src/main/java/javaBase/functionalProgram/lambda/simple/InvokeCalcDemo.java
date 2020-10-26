package javaBase.functionalProgram.lambda.simple;

/**
 * @author jhmarryme.cn
 * @date 2019/7/17 11:30
 */
public class InvokeCalcDemo {
    public static void main(String[] args) {
        /*invokeCalc(12, 100, (int a, int b) -> {
            return a - b;
        });*/

        //另一种写法
        invokeCalc(122, 12, (a, b) -> a + b);


        invokeCook(() -> System.out.println("正在做饭"));
    }

    private static void invokeCalc(int a, int b, CalcForLambda calc){
        int result = calc.calc(a, b);
        System.out.println("result : " + result);
    }
    private static void invokeCook(CookForLambda cook){
        cook.makeFood();
    }
}
