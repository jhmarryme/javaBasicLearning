package reading.nowCoderAlgorithm.chapter2;

/**
 * @author jhmarryme.cn
 * @date 2019/7/3 15:36
 */

public class MergeTest {

    private static int getSum(int[] arr){

        if (arr.length < 2 || arr == null) {
            return 0;
        }

        return sortProcess(arr, 0, arr.length - 1);
    }

    private static int sortProcess(int[] arr, int L, int R) {

        if (R == L) {
            return 0;
        }

        int mid = L + (R - L) / 2;
        return sortProcess(arr, L, mid) +
            sortProcess(arr, mid + 1, R) +
            merge(arr, L, mid  , R);

    }

    private static int merge(int[] arr, int L, int mid, int R) {

        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int sum = 0;

        int[] help = new int[R - L + 1];
        while(p1 <= mid && p2 <= R){
            if (arr[p2] > arr[p1]) {
                sum += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
            }
            help[i++] = (arr[p1] < arr[p2]) ? arr[p1++] : arr[p2++];
        }

        while(p1 <= mid){
            help[i++] = arr[p1++];

        }
        while(p2 <= R){
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++){
            arr[L + j] = help[j];
        }
        return sum;
    }


    /**
     * 测试求小和 4 1 3 0 5 6 求每个数左边比他小的数之和的总和  结果= 22
     * 归并排序的练习
     * @param args
     */
    public static void main(String[] args) {
        /*int testTime = 50000;
        int size = 100;
        int value = 100;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = DigitalArrayUtil.generateRandomArray(size, value);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            getSum(arr1);
            DigitalArrayUtil.comparator(arr2);
            if (!DigitalArrayUtil.isEqual(arr1, arr2)) {
                success = false;
                break;
            }
        }
        System.out.println("success = " + success);*/


        int[] arr = {1,3,9,4,7,8};
        int sum = getSum(arr);
        System.out.println("sum = " + sum);
    }


}
