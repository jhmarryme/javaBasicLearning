package utils;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/6/19 14:58
 */
public class DigitalArrayUtil {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] =  arr[j];
        arr[j] = temp;
    }

    /**
     * 比较器
     * @param arr
     */
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    /**
     * 生成长度随机, 值随机的数组
     * @param size
     * @param value
     * @return
     */
    public static int[] generateRandomArray(int size, int value){
        int[] arr = new int[(int)(Math.random() * size) + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ((int)((value + 1) * Math.random())) - ((int)(value * Math.random()));
        }
        return arr;
    }


    public static boolean isEqual(int[] arr1, int[] arr2) {

        if (arr1 == null || arr2 ==null) {
            return false;
        }

        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }
}
