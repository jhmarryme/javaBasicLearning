package reading.nowCoderAlgorithm.chapter2;

import reading.nowCoderAlgorithm.utils.DigitalArrayUtil;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/7/3 18:53
 */
public class Code_04_QuickSort {


    private static void quickSort(int[] arr, int L, int R){
        if (L < R){
            //随机快速排序
            DigitalArrayUtil.swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
            //划分区域
            int[] partition = partition(arr, L, R);
            quickSort(arr, L, partition[0] - 1);
            quickSort(arr, partition[1] + 1, R);
        }
    }

    private static int[] partition(int[] arr, int L, int R){
        
        int less = L - 1;
        //为了少用一个变量, 这里大于区域直接指向最后一位, 就避免了最后被改变, 但要在最后进行交换
        int more = R;
        //一直循环到大于区域为止
        while(L < more){
            if (arr[L] < arr[R]) {
                //如果属于小于区 域
                DigitalArrayUtil.swap(arr, L++, ++less);
            } else if (arr[L] > arr[R]){
                //如果属于大于区域, 因为此时所在的位置是等于区, 所以指针不动, 接着比较, 直到进入正确的大于区域
                DigitalArrayUtil.swap(arr, L, --more);
            } else{
                //属于等于区域, 不做改变
                L++;
            }
        }
        //为之前的准备 做交换
        DigitalArrayUtil.swap(arr, more, R);
        // 值得注意的是这里等于区域到more为止, 因为之前最后一位作为保留, 后又进行了交换, 所以大于区域的第一位实际是等于区的数
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
