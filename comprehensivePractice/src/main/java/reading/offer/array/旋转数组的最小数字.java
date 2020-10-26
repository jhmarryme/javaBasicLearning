package reading.offer.array;

/**
 * @author jhmarryme.cn
 * @date 2019/9/6 13:25
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class 旋转数组的最小数字 {

    /**
     * 利用二分法定位最小的数字
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        int start = 0, end = array.length-1;
        int mid = 0;

        while(start < end){
            mid = start + (end - start) / 2;
            // 如果中位数 > 末尾数, 就可以排除掉中位数左边部分
            if(array[mid] > array[end]){
                start = mid + 1;
            }
            // 如果中位数  < 末尾数, 就可以排除掉中位数右边的部分, 但保留该中位数, 因为可能是潜在的最小值
            else if(array[mid] < array[end]){
                end = mid;
            }
            // 相等, 有可能是潜在的最小值, 从末尾逐步向左移动.
            else{
                end = end - 1;
            }
        }

        return array[start];
    }
}
