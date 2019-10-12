package javaBase.recursion;

/**
 * @author jhmarryme.cn
 * @date 2019/7/21 11:07
 */
public class SimpleRecursionTest {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getSumByRecursion(10));

        System.out.println(getFactorial(5L));
    }

    /**
     * 递归求1~n的和
     * @param n
     * @return
     */
    public static int getSumByRecursion(int n){
        if (n == 1){
            return n;
        }

        return n + getSumByRecursion(n - 1);
    }

    /**
     * 递归求阶乘
     * @param n
     * @return
     */
    public static Long getFactorial(Long n){
        if (n == 1) {
            return n;
        }

        return n * getFactorial(n - 1);
    }
}
