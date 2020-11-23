package reading.nowCoderAlgorithm.chapter3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jhmarryme.cn
 * @date 2019/7/28 20:06
 */
public class Code_03_StackAndQueueConvert {

    /**
     * 利用队列实现的栈结构
     */
    public static class StackByQueue{
        private Queue<Integer> queue;
        private Queue<Integer> help;

        public StackByQueue() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public Integer pop(){

            if (queue.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }

            // 把数据全部放入新的队列的中, 只剩下最后一个 就是最后进来的
            while(queue.size() > 1){
                help.add(queue.poll());
            }
            int result = queue.remove();
            // 此时queue为空了, 将help作为新的queue, 交换
            swap();
            return result;
        }


        public void swap(){
            Queue<Integer> temp;
            temp = queue;
            queue = help;
            help = temp;
        }

        public Integer peek(){
            if (queue.isEmpty()) {
                throw new RuntimeException("stack is empty");
            }

            // 把数据全部放入新的队列的中, 只剩下最后一个 就是最后进来的
            while(queue.size() > 1){
                help.add(queue.poll());
            }

            int result = queue.poll();
            // 只是返回, 不弹出, 所以要重新入queue
            help.add(result);
            // 此时queue为空了, 将help作为新的queue, 交换
            swap();
            return result;

        }

        public void push(int num){
            queue.add(num);
        }
    }


    /**
     * 通过栈结构实现的队列
     */
    public static class QueueByStack{

        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public QueueByStack() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void push(int num){
            stackPush.push(num);
        }


        public Integer pop(){
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("queue is empty");
            } else if (stackPop.isEmpty() && !stackPush.isEmpty()){
                //只有在pop为空时才能将push逆序存入pop,否则会顺序乱掉
                reverseStatck();
            }
            return stackPop.pop();
        }

        /**
         * 将push逆序存入另一个栈pop
         * 逆序后的pop的弹出就相当于先进先出了
         */
        private void reverseStatck() {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()){
                    //必须一次性将push中的数据全部逆序存入pop
                    stackPop.push(stackPush.pop());
                }
            }

        }

        public Integer peek(){
            if (stackPop.isEmpty() && stackPush.isEmpty()) {
                throw new RuntimeException("queue is empty");
            } else if (stackPop.isEmpty() && !stackPush.isEmpty()){
                reverseStatck();
            }
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        /*final StackByQueue stack = new StackByQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());*/
        final QueueByStack queue = new QueueByStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        queue.push(7);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    }

}
