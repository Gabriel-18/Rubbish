package chapter_1_stackandqueue;

import java.util.Stack;

/**
 * @author Kelper
 */
public class Problem_01_GetMinStack {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        /**
         * put the data onto the stack
         * @param newNum new element to be added
         */
        public void push(int newNum) {
            this.stackData.push(newNum);
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()){
                this.stackMin.push(newNum);
            }

        }

        /**
         *
         * @return get the minimum element of stackMin
         */
        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("your stack is empty");
            }
            return this.stackMin.peek();
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public static class MyStack2 {
            private Stack<Integer> stackData;
            private Stack<Integer> stackMin;

            public MyStack2() {
                this.stackData = new Stack<>();
                this.stackMin = new Stack<>();
            }

            public void push(int newNum) {
                this.stackData.push(newNum);
                if (this.stackMin.isEmpty()) {
                    this.stackMin.push(newNum);
                } else if (newNum < this.getMin()) {
                    this.stackMin.push(newNum);
                } else {
                    int newMin = this.stackMin.peek();
                    this.stackMin.push(newMin);
                }
            }

            public int getMin() {
                if (this.stackMin.isEmpty()) {
                    throw new RuntimeException("your stack is empty");
                }
                return this.stackMin.peek();
            }

            public int pop() {
                if (this.stackData.isEmpty()) {
                    throw new RuntimeException("Your stack is empty");
                }
                this.stackMin.pop();
                return this.stackData.pop();
            }
        }
        public static void main(String[] args) {
            MyStack1 stack1 = new MyStack1();
            stack1.push(3);
            System.out.println(stack1.getmin());
            stack1.push(4);
            System.out.println(stack1.getmin());
            stack1.push(1);
            System.out.println(stack1.getmin());
            System.out.println(stack1.pop());
            System.out.println(stack1.getmin());

            System.out.println("==============================");

            MyStack2 stack2 = new MyStack2();
            stack2.push(3);
            System.out.println(stack2.getMin());
            stack2.push(4);
            System.out.println(stack2.getMin());
            stack2.push(1);
            System.out.println(stack2.getMin());
            System.out.println(stack2.pop());
            System.out.println(stack2.getMin());

        }
    }
}
