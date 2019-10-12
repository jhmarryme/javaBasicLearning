package chapter2;

import utils.DigitalArrayUtil;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author jhmarryme.cn
 * @date 2019/7/28 10:35
 */
public class Code_06_BucketSort {
    /**
     * 计数排序
     * @param arr
     */
    private static void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            max = Math.max(i, max);
        }

        int[] bucket = new int[max + 1];

        for (int i : arr) {
            bucket[i]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while(bucket[i]-- > 0){
                arr[index++] = i;
            }
        }
    }

    /**
     * 测试桶排序
     * @param args
     */
    public static void main(String[] args) {
        int testTime = 50000;
        int size = 100;
        int value = 100;
        boolean success = true;
        long l = System.currentTimeMillis();
        for (int i = 0; i < testTime; i++) {

            int[] arr1 = new int[(int) ((size + 1) * Math.random())];

            for (int j = 0; j < arr1.length; j++) {
                arr1[j] = ((int)(Math.random() * 201));

            }


            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            bucketSort(arr1);
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
}
