package stackandqueue;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 *
 * 栈的顺序为后进先出，而队列的顺序为先进先出。
 * 使用两个栈实现队列，一个元素需要经过两个栈才能出队列，
 * 在经过第一个栈时元素顺序被反转，经过第二个栈时再次被反转，此时就是先进先出顺序。
 *
 */
public class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2out();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        in2out();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    /**
     * 在经过第一个栈时元素顺序被反转，经过第二个栈时再次被反转，此时就是先进先出顺序。
     */
    private void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }

}
