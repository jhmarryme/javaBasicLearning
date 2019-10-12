package utils;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/7/9 10:28
 */
public class MergeSortFinalTest {
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
        if (arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {

        if (L >= R){
            return;
        }

        int mid = L + (R - L) / 2;

        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;

        int i = 0;
        while(p1 <= mid && p2 <= R){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }
}
