package reading.nowCoderAlgorithm.chapter1;


import reading.nowCoderAlgorithm.utils.DigitalArrayUtil;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/6/19 15:02
 */
public class Code_01_InsertionSort {

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1] ; j--) {
                DigitalArrayUtil.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int size = 100;
        int value = 100;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = DigitalArrayUtil.generateRandomArray(size, value);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            insertionSort(arr1);
            DigitalArrayUtil.comparator(arr2);
            if (!DigitalArrayUtil.isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.out.println("success = " + success);
    }
}
