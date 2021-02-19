package 高频面试题.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _32最长有效括号 {
    class Solution {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            Deque<Integer> stack = new LinkedList<Integer>();
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                    // 遇到 ) 先弹

                } else {
                    stack.pop();
                    // 空的才放进来
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        // 不为空 计算
                        maxans = Math.max(maxans, i - stack.peek());
                    }
                }
            }
            return maxans;
        }
    }
}
