package 高频面试题.leetcode;

import java.util.Stack;

public class _20有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            // 处理右括号
            if (c == '('){
                stack.push(')');
            }
            else if (c == '[') {
                stack.push(']');
            }
            else if (c == '{') {
                stack.push('}');
            }
            // 处理左括号
            else if (stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        // 全部处理完
        return stack.isEmpty();
    }
}
