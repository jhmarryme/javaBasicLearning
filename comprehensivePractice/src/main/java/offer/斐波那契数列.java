package offer;

/**
 * @author jhmarryme.cn
 * @date 2019/9/6 14:12
 */
public class 斐波那契数列 {

    /**
     * 递归版本, 时间复杂度很高
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 非递归版本
     * 因为第n项 是 n-1项 n-2项的和
     * 所以只需要从一开始设定前两项的值, 每次逐步替换即可
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int one = 0, two = 1;
        int res = 0;
        for(int i = n; i > 1; i--){
            res = one + two;
            //此时原来的n-2项就该被原来的n-1项替换
            one = two;
            //此时原来的n-1项被原来的n项替换
            two = res;
        }
        return res;
    }
}
