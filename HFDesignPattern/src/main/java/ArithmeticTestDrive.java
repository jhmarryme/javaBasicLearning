import java.util.Scanner;

/**
 * @author jhmarryme.cn
 * @date 2019/9/18 8:58
 */

public class ArithmeticTestDrive{

    public static void main(String[] args) {
        Arithmetic add = new Add();
        Arithmetic sub = new Subtraction();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数(必须是小数)");
        double a = scanner.nextDouble();
        System.out.println("请输入第二个数(必须是小数)");
        double b = scanner.nextDouble();

        System.out.printf("%.2f + %.2f = %.2f", a, b, add.operate(a, b));
        System.out.println();
        System.out.printf("%.2f - %.2f = %.2f", a, b, sub.operate(a, b));
    }

}

interface Arithmetic {
    double operate(double a, double b);
}

class Add implements Arithmetic{

    public double operate(double a, double b) {
        return a + b;
    }
}

class Subtraction implements Arithmetic{

    public double operate(double a, double b) {
        return a - b;
    }
}
