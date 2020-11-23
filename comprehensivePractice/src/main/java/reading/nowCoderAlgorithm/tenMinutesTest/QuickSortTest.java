package reading.nowCoderAlgorithm.tenMinutesTest;


import reading.nowCoderAlgorithm.utils.DigitalArrayUtil;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/7/31 17:12
 */
public class QuickSortTest {

    public static void quickSort(int[] arr, int L, int R){
        if (L > R){
            return;
        }
        DigitalArrayUtil.swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
        int[] p = partition(arr, L, R);
        quickSort(arr, L, p[0] - 1);
        quickSort(arr, p[1] + 1, R);

    }
    public static int[] partition(int[] arr, int L, int R){

        int less = L - 1;
        int more = R;

        while(L < more){
            if (arr[L] < arr[R]){
                DigitalArrayUtil.swap(arr, L++, ++less);
            } else if (arr[L] > arr[R]){
                DigitalArrayUtil.swap(arr, L, --more);
            } else {
                L++;
            }
        }

        DigitalArrayUtil.swap(arr, R, more);

        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int size = 100;
        int value = 100;
        boolean success = true;
        long l = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = DigitalArrayUtil.generateRandomArray(size, value);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            quickSort(arr1, 0, arr1.length - 1);
            DigitalArrayUtil.comparator(arr2);
            if (!DigitalArrayUtil.isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("success = " + success);
        System.out.println("l2 = " + (l2 - l));
    }
}
