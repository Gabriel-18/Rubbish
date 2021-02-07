package 剑指offer;

import java.util.Stack;

public class 包含min函数的栈 {
    private Stack<Integer> dataStack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    // b、不知道有什么用
    public int top() {
        return minStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
