package 剑指offer;

import java.util.Stack;

// 入栈操作全部交给in处理
// 出栈操作 先判断 out是否为空
// 当out为空时 就将in里面的元素全部 弹入out
// 当out出栈出完了 就抛出异常
public class 用两个栈实现队列 {
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return out.pop();
    }
}
