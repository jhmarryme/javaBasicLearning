package chapter1;

/**
 * @author jhmarryme.cn
 * @date 2019/6/19 15:46
 */
public class RecursionTest {

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 4, 6};
        int max = getMax(arr, 0, arr.length - 1);
        System.out.println("max = " + max);
        System.out.println(factorial(5));
    }

    private static int getMax(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex){
            return arr[leftIndex];
        }
        int mid = (leftIndex + rightIndex) / 2;
        int maxLeft = getMax(arr, leftIndex, mid);
        int maxRight = getMax(arr, mid + 1, rightIndex);
        return Math.max(maxLeft, maxRight);
    }




    public static long factorial(int n){
        if (n == 1){
            return n;
        }
        return n * factorial(n - 1);
    }


}
