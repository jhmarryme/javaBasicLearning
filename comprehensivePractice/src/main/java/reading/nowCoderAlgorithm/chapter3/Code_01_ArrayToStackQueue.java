package reading.nowCoderAlgorithm.chapter3;

/**
 * 用数组结构实现大小固定的队列和栈
 * @author jhmarryme.cn
 * @date 2019/7/28 17:05
 */
public class Code_01_ArrayToStackQueue {


    /**
     * 简易栈实现
     */
    public static class ArrayStack{
        private Integer[] arr;
        private Integer size;

        public ArrayStack(int initSize) {
            arr = new Integer[initSize];
            size = 0;
        }

        public Integer pop(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException("栈已空");
            }
            return arr[--size];
        }
        public void push(int num){
            if (size == arr.length){
                throw new ArrayIndexOutOfBoundsException("栈已满");
            }
            arr[size++] = num;
        }
        public Integer getSize(){
            return size;
        }
    }


    /**
     * 简易的队列实现
     */
    public static class ArrayQueue{
        private Integer[] arr;
        private Integer size;
        private Integer end;
        private Integer start;

        public ArrayQueue(int initSize) {
            if (initSize < 0){
                throw new IllegalArgumentException("初始化长度不能小于0");
            }
            arr = new Integer[initSize];
            size = 0;
            end = 0;
            start = 0;
        }

        public Integer peek(){
            if (size == 0) {
                return null;
            }
            return arr[start];
        }


        public void push(int num){
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("队列已满");
            }
            arr[end] = num;
            size++;
            end = nextIndex(end);
        }

        public Integer poll(){
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("队列为空");
            }
            size--;
            int tmp = start;
            start = nextIndex(start);
            return arr[tmp];
        }

        public int nextIndex(int index){
            return index == arr.length - 1 ? 0 : index + 1;
        }
    }


    public static void main(String[] args) {
        /*final ArrayQueue queue = new ArrayQueue(3);
        queue.push(1);
        System.out.println(queue.poll());
        queue.push(2);
        queue.push(3);
        System.out.println(queue.poll());
        queue.push(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());*/

        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
