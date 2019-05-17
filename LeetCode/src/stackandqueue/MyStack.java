package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    /**
     * 在将一个元素 x 插入队列时，为了维护原来的后进先出顺序，需要让 x 插入队列首部。
     * 而队列的默认插入顺序是队列尾部
     * 因此在将 x 插入队列尾部之后，需要让除了 x 之外的所有元素出队列，再入队列。
     * @param x the element to add
     */
    public void push(int x) {
        queue.add(x);
        int cnt = queue.size();
        while (cnt-- > 1) {
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */