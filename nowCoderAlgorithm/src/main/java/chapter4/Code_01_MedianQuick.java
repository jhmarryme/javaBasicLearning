package chapter4;

import utils.DigitalArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 随时找到数据流的中位数
 * 【题目】
 * 有一个源源不断地吐出整数的数据流，
 * 假设你有足够的空间来 保存吐出的数。请设计一个名叫MedianHolder的结构， MedianHolder可以随时取得之前吐出所有数的中位数。
 * 【要求】
 * 1．如果MedianHolder已经保存了吐出的N个数，那么任意时刻 将一个新数加入到MedianHolder的过程，其时间复杂度是 O(logN)。
 * 2．取得已经吐出的N个数整体的中位数的过程，时间复杂度为 O(1)。
 * @author jhmarryme.cn
 * @date 2019/8/1 15:43
 */
public class Code_01_MedianQuick {

    /**
     * 1. 建立两个堆, 一个大根堆, 一个小根堆, 目的是将数据存储分为两个部分, 一个部分从小到大(大根堆), 一个部分从大到小(小根堆).
     * 2. 两个堆让数据走向变成了一个∩型,  只需要弹出两个堆的顶部数据即可找到中位数
     */
    public static class MedianHolder{
        // 大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;

            }
        });
        //小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;

            }
        });

        /**
         * 将数据存入相应的堆, 大根堆存从小到大的数, 小根堆存从大到小的数
         * 1. 大根堆没有数据 直接存入
         * 2. 数据小于大根堆堆顶, 则存入大根堆, 否则存入小根堆
         * @param num
         */
        public void addNum(int num){

            if (maxHeap.isEmpty()){
                maxHeap.add(num);
                return;
            }
            if (maxHeap.peek() >= num){
                maxHeap.add(num);
            } else {

               /*
               //优化前的存入方式
                minHeap.add(num);*/
                // 优化后的存入小根堆的方式
                if (minHeap.isEmpty()){
                    minHeap.add(num);
                    return;
                }

                //如果这个数比小根堆堆顶还要小, 则直接存入大根堆
                if (num < minHeap.peek()){
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }

            //调整两个堆
            modifyHeap();
        }

        public Integer getMedian(){
            int maxHeapSize = this.maxHeap.size();
            int minHeapSize = this.minHeap.size();
            if (maxHeapSize + minHeapSize == 0) {
                return null;
            }
            Integer maxHeapHead = this.maxHeap.peek();
            Integer minHeapHead = this.minHeap.peek();

            //判断长度和是否为偶数
            if (((maxHeapSize + minHeapSize) & 1) == 0) {
                return (maxHeapHead + minHeapHead) / 2;
            }
            // 奇数的情况
            return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;

        }

        /**
         * 调整两个堆的大小, 保证长度差不超过1
         */
        private void modifyHeap() {
            if (maxHeap.size() > minHeap.size() && (maxHeap.size() - minHeap.size()) > 1){
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() && (minHeap.size() - maxHeap.size()) > 1) {
                maxHeap.add(minHeap.poll());
            }
        }


    }
    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = DigitalArrayUtil.generateRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNum(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");
    }
}
