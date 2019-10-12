package chapter1;


import utils.DigitalArrayUtil;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/6/17 10:27
 */
public class Code_00_BubbleSort {


    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--){
            for (int i = 0; i < end; i ++){
                if (arr[i] > arr[i + 1]) {
                    DigitalArrayUtil.swap(arr, i , i + 1);
                }
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

            bubbleSort(arr1);
            DigitalArrayUtil.comparator(arr2);
            if (!DigitalArrayUtil.isEqual(arr1, arr2)) {
                success = false;

                break;
            }
        }
        System.out.println("success = " + success);
    }
}
