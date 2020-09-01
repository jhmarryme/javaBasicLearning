package designPatternLesson.strategy.enumeration;

import lombok.Getter;

/**
 * description: 模拟拓展枚举
 *
 * @Author: Wjh
 * @Date: 2020/9/1 11:36
 * @Modified By:
 */
@Getter
public enum BasicOperation implements Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    },
    ;
    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
