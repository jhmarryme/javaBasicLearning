package offer.stackAndQueue;
import java.util.Stack;
/**
 * @author jhmarryme.cn
 * @date 2019/9/6 13:30
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class 两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        build();
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        return -1;
    }

    public void build(){
        if(!stack1.isEmpty() && stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }
}
