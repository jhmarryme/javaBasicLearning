package reading.offer;

/**
 * @author jhmarryme.cn
 * @date 2019/9/6 14:39
 */
public class 数值的整数次方 {
    public double Power(double base, int exponent) {

        /**
         当指数为负时, 结果为倒数, 此时需判断底数是否为0(0不能作为分母)
         **/
        boolean negativeFlag = false;
        if(exponent < 0){
            if(base == 0){
                throw new RuntimeException("分母为0");
            }
            exponent = -exponent;
            negativeFlag = true;
        }

        double res = getPower(base, exponent);

        if(negativeFlag){
            res = 1 / res;
        }

        return res;

    }

    /**
     借用斐波那契数列计算时的公式的思想
     如16次方时, 计算8次方 * 8次方的值即可
     如17次方时, 计算8次方 * 8次方 * base的值即可
     **/
    public double getPower(double base, int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }

        double res = getPower(base, exponent >> 1);
        res = res * res;
        if((exponent & 1) != 0){
            res = res * base;
        }

        return res;
    }
}
