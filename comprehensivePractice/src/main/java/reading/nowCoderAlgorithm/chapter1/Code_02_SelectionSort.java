package reading.nowCoderAlgorithm.chapter1;

import reading.nowCoderAlgorithm.utils.DigitalArrayUtil;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/6/19 13:11
 */
public class Code_02_SelectionSort {

    public static void selectionSort(int[] arr){
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = (arr[minIndex] < arr[j]) ? minIndex : j;
            }
            DigitalArrayUtil.swap(arr, minIndex, i);
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

            selectionSort(arr1);
            DigitalArrayUtil.comparator(arr2);
            if (!DigitalArrayUtil.isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.out.println("success = " + success);
    }

}
