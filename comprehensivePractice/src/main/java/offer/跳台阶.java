package offer;

/**
 * @author jhmarryme.cn
 * @date 2019/9/6 14:24
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class 跳台阶 {
    public int JumpFloor(int target) {
        if(target == 2 || target == 1){
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }


    /**
     * 变态跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target == 1){
            return target;
        }

        return 2 * JumpFloorII(target - 1);
    }
}
