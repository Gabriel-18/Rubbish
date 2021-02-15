package 高频面试题.leetcode;

import java.util.LinkedList;

public class 剑指Offer09用两个栈实现队列 {
    class Queue{
        LinkedList<Integer> in, out;
        public Queue() {
            in = new LinkedList<Integer>();
            out = new LinkedList<Integer>();
        }
        public void appendTail(int value) {
            in.addLast(value);
        }
        public int deleteHead() {
            if(!out.isEmpty()) {
                return out.removeLast();
            }
            if(in.isEmpty()) {
                return -1;
            }
            while(!in.isEmpty()) {
                out.addLast(in.removeLast());
            }
            return out.removeLast();
        }
    }

}
