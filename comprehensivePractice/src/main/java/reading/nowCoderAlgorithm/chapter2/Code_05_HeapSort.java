package reading.nowCoderAlgorithm.chapter2;

import reading.nowCoderAlgorithm.utils.DigitalArrayUtil;

import java.util.Arrays;

/**
 * @author jhmarryme.cn
 * @date 2019/7/4 10:42
 */
public class Code_05_HeapSort {


    /**
     * 堆排序
     * 1. 建立大根堆
     * 2. 堆循环处理
     *  2.1 首尾交换
     *  2.2 调整位置
     * @param arr
     */
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        
        //建立大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        while (--size > 0){
            DigitalArrayUtil.swap(arr, 0, size);
            heapfiy(arr, 0, size);
        }

    }

    /**
     * 交换首尾后的 堆排序处理
     * @param arr
     * @param index
     * @param heapSize
     */
    private static void heapfiy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize){
            // 当右节点存在且大于左节点时 取右节点
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index :largest;
            if (largest == index) {
                // 代表子节点没有比自己大的了
                break;
            }
            DigitalArrayUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     * 建立大根堆
     * @param arr
     * @param index
     */
    private static void heapInsert(int[] arr, int index) {

        while(arr[index] > arr[(index - 1) / 2]){
            DigitalArrayUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    /**
     * 测试堆排序
     * @param args
     */
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
}
