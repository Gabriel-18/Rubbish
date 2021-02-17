package 高频面试题.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class _402移掉K位数字 {

    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>(num.length());
        for(char c : num.toCharArray()){
            // 遇小，立马删掉栈顶的数
            while(k > 0 && !stack.isEmpty() && c < stack.peek()){
                stack.pop();
                k--;
            }
            // 遇大 放入栈顶
            // 不放0
            if( c != '0' || !stack.isEmpty()){
                stack.push(c);

            }
        }
// 如果还没删够，要从stack继续删，直到k=0
        while( k > 0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }

        StringBuffer buffer = new StringBuffer();
        while(!stack.isEmpty()){
            buffer.append(stack.pollLast());
        }
// 如果栈空了，返回"0"，如果栈非空，转成字符串返回
        return buffer.length() == 0 ? "0" : buffer.toString();
    }
}
