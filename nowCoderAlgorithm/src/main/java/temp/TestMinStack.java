package temp;

/**
 * @author jhmarryme.cn
 * @date 2019/8/23 15:39
 */
public class TestMinStack {
    public static void main(String[] args) {

        MinStack stack = new MinStack();
        stack.push(512);
        stack.push(-1024);
        stack.push(-1024);
        stack.push(512);

        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }
}
