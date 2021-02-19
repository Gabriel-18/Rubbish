package 高频面试题.leetcode;

import java.util.Stack;

public class _739每日温度 {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            int cur = T[i];
            while (!stack.isEmpty() && cur > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
