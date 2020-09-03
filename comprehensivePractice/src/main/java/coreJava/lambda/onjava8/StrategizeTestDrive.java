package coreJava.lambda.onjava8;

import java.util.Arrays;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/3 17:58
 * @Modified By:
 */
public class StrategizeTestDrive {
    Strategy strategy;
    String msg;

    public StrategizeTestDrive(String msg) {
        // Soft 作为默认策略
        strategy = new Soft();
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
            new Strategy() { // 匿名内部类
                public String approach(String msg) {
                    return msg.toUpperCase() + "!";
                }
            },
            // Lambda 表达式
            msg1 -> msg1.substring(0, 5),
            // 方法引用
            Unrelated::twice
        };

        StrategizeTestDrive testDrive = new StrategizeTestDrive("Hello world");

        testDrive.communicate();

        // 每次调用 communicate() 都会产生不同的行为，具体取决于此刻正在使用的策略代码对象。我们传递的是行为，而并不仅仅是数据
        Arrays.stream(strategies).forEach(strategy1 -> {
            testDrive.changeStrategy(strategy1);
            testDrive.communicate();
        });
    }
}
