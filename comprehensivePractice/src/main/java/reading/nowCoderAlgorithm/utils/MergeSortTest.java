package reading.nowCoderAlgorithm.utils;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/7/5 23:06
 */
public class MergeSortTest {
    public static void main(String[] args) {
        int testTime = 50000;
        int size = 100;
        int value = 100;
        boolean success = true;
        long l = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = DigitalArrayUtil.generateRandomArray(size, value);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            mergeSort(arr1);
            DigitalArrayUtil.comparator(arr2);
            if (!DigitalArrayUtil.isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.println("success = " + success);
        System.out.println("运行时间 = " + (l2 - l));
    }

    private static void mergeSort(int[] arr) {

    }
}
