package chapter2;

import utils.DigitalArrayUtil;

import java.util.Arrays;

/**
 * 排序之后两个数最大差值
 * @author jhmarryme.cn
 * @date 2019/7/28 12:28
 */
public class Code_07_MaxGap {



    public static int getMaxGap(int[] arr){

        if (arr == null || arr.length < 2){
            return 0;
        }

        int len = arr.length;
        //最大值与最小值设置
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        //计算数组的上下限
        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        //三个辅助数组, 用作桶的判断标准
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];

        //上下限相等, 代表只有一种数  不需要排序
        if (min == max) {
            return 0;
        }

        //把数存入桶内
        for (int num : arr) {
            int bid = countBucketId(num, len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], num) :num;
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], num) :num;
            hasNum[bid] = true;
        }

        int result = 0;

        //当前桶有值的时候, 上一个桶的最大值与当前桶的最小值依次比较
        //lastInedx为上一个桶的最大值
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                result = Math.max(result, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return result;
    }

    /**
     * 计算该数所在的桶的id是多少
     * @param num
     * @param len
     * @param min
     * @param max
     * @return
     */
    private static int countBucketId(int num, int len, int min, int max) {
        //相对位置计算
        return (int)((num - min) * len / (max - min));
    }

    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }



    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = DigitalArrayUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            if (getMaxGap(arr1) != comparator(arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
