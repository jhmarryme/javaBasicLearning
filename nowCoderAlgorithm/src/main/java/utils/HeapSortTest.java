package utils;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/7/5 11:32
 */
public class HeapSortTest {


    public static void main(String[] args) {
        int testTime = 50000;
        int size = 100;
        int value = 100;
        boolean success = true;
        long l = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = DigitalArrayUtil.generateRandomArray(size, value);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            heapSort(arr1);
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

    private static void heapSort(int[] arr) {

        if (arr.length < 2 || arr == null){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        while(--size > 0){
            DigitalArrayUtil.swap(arr, 0, size);
            heapify(arr, 0, size);
        }

    }

    private static void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            DigitalArrayUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
            while (arr[index] > arr[(index - 1) / 2]){
                DigitalArrayUtil.swap(arr,index, (index - 1) / 2 );
                index = (index - 1) / 2;
            }
    }
}
