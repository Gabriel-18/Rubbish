package 高频面试题.leetcode;

import java.util.Stack;
//对于实现最小值队列问题，可以先将队列使用栈来实现，
// 然后就将问题转换为最小值栈，这个问题出现在 编程之美：3.7。
public class _155最小栈 {
    class MinStack {
        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        private int min;

        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        // 一起进
        public void push(int x) {
            dataStack.add(x);
            min = Math.min(min, x);
            minStack.add(min);
        }

        // 一起出
        // 考虑下空栈的情况 min设为一个初始值
        public void pop() {
            dataStack.pop();
            minStack.pop();
            min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
