package javaBase.enumBase.enumLearning;

import lombok.*;

/**
 * description: 枚举的基本使用方法简单练习 - 枚举类型的属性,方法和构造函数
 * 1. 枚举的比较必须用==, 使用equals会出现问题
 *
 * @Author: Wjh
 * @Date: 2020/8/12 8:59
 * @Modified By:
 */
@Data
public class Pizza {
    private PizzaStatus status;

    @AllArgsConstructor
    @Getter
    @NoArgsConstructor
    public enum  PizzaStatus {
        ORDERED (5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }
    }

    /*
     * description:  判断Pizza是否已经准备好
     * @Param: []
     * @Return: boolean
     * @Author: Wjh
     * @Date: 2020/8/12 9:44
     * @Throws
     */
    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver(){
        // 打印当前状态下, 提交需要的时间
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }


    public static void main(String[] args) {
        Pizza pizza = new Pizza();
        pizza.setStatus(PizzaStatus.READY);
        System.out.println("pizza.isDeliverable() = " + pizza.isDeliverable());
    }
}
