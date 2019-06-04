package chapter_1_stackandqueue;

import java.util.Stack;

/**
 * using two stacks to implement queue
 * 1.如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush中的数据全部压入。
 * 2.如果stackPop不为空，stackPush绝对不能向stackPop中压入数据。违反了以上两点都会发生错误。
 * 这个选择的时机可以有很多，调用add、poll和peek三种方法中的任何一种时发生“压”入数据的行为都
 * 是可以的。
 * so every operation needs pushToPop
 */
public class Problem_02_TwoStacksImplementQueue {
    public static class TwoStacksQueue {
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPop = new Stack<>();
            stackPush = new Stack<>();
        }

        //pop all elements stackPush onto stackPop
        public void pushToPop() {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        /**
         *
         * @param pushInt the element to be added
         */
        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }
        /**
         * Retrieves and removes the head of the queue represented by this deque
         * (in other words, the first element of this deque), or returns null if this deque is empty.
         * @param
         */
        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("queue is empty");
            }
            pushToPop();
            return stackPop.pop();
        }

        /**
         * the head of the queue represented by this deque, or null if this deque is empty
         * @return
         */
        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            pushToPop();
            return stackPop.peek();
        }

        public static void main(String[] args) {
            TwoStacksQueue test = new TwoStacksQueue();
            test.add(1);
            test.add(2);
            test.add(3);
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.peek());
            System.out.println(test.poll());
            System.out.println(test.poll());
        }
    }
}
