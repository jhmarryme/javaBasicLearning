package chapter3;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返 回栈中最小元素的操作。
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 * @author jhmarryme.cn
 * @date 2019/7/28 21:17
 */
public class Code_02_GetMinStack {

    public static class MinStack{
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int num){
            //当最小栈为空, 直接存入
            if (minStack.isEmpty()){
                minStack.push(num);
            } else if (num <= minStack.peek()){
                // 代表存入的值是最小值, 一起存入最小栈
                // 只有大于的时候不存
                minStack.push(num);
            }
            dataStack.push(num);

        }

        public Integer pop(){
            if (dataStack.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }
            // 取数据的时候 判断要弹出的数据与最小栈的栈顶是否相等
            // 如果相等, 一并弹出, 代表弹出的是一个最小值.
            if (dataStack.peek().equals(minStack.peek())){
                minStack.pop();
            }
            return dataStack.pop();
        }

        public Integer getMin(){
            return minStack.peek();
        }
    }


    public static void main(String[] args) {

        final MinStack stack = new MinStack();

        stack.push(9);
        stack.push(4);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(3);

        System.out.println(stack.getMin());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}
