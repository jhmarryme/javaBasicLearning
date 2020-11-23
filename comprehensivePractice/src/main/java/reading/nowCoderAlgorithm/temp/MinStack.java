package reading.nowCoderAlgorithm.temp;

import java.util.Stack;

class MinStack {

    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> stack = new  Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(minStack.isEmpty() || x <= minStack.peek() ){
            minStack.add(x);
        }
        stack.add(x);
    }
    
    public void pop() {
        if(!minStack.isEmpty() && minStack.peek() == stack.peek()){
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

