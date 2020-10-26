package reading.offer;

/**
 * @author jhmarryme.cn
 * @date 2019/9/6 14:35
 */
public class 二进制中一的个数 {
    public int NumberOf1(int n) {
        /**
         int flag = 1, count = 0;
         while(flag != 0){
         if((n & flag) != 0){
         count++;
         }
         flag = flag << 1;
         }
         return count;
         **/

        // 将n-1 和 n 相与得到新的数作为n
        int count = 0;
        while(n != 0){
            n = (n - 1) & n;
            count++;
        }
        return count;
    }
}
