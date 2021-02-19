package 高频面试题.leetcode;

import java.util.Stack;
// 总结就是栈顶和栈顶的下一个元素以及要入栈的三个元素来接水

/**
 * 前面我们讲到，优化思路将问题转化为：给定一个数组，如何求得任意位置的左半边的最大值和右半边的最大值。
 *
 * 但仔细一想，其实我们并不需要找两侧最大值，只需要找到两侧最近的比当前位置高的柱子就行了。
 *
 * 针对这一类找最近值的问题，有一个通用解法：单调栈。
 *
 * 单调栈其实就是在栈「后进先出」的基础上，维持一个栈内元素单调。
 *
 * 在这道题，由于需要找某个位置两侧比其高的柱子（只有两侧有比当前位置高的柱子，当前位置才能接下雨水），我们可以维持栈内元素的单调递减。
 *
 * PS. 找某侧最近一个比其大的值，使用单调栈维持栈内元素递减；找某侧最近一个比其小的值，使用单调栈维持栈内元素递增 ...
 *
 * 当某个位置的元素弹出栈时，例如位置 a ，我们自然可以得到 a 位置两侧比 a 高的柱子：
 *
 * 一个是导致 a 位置元素弹出的柱子（ a 右侧比 a 高的柱子）
 * 一个是 a 弹栈后的栈顶元素（a 左侧比 a 高的柱子）

 */
public class _42接雨水 {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ret = 0;
        // 收集不了水
        if (height.length < 3) {
            return 0;
        }

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int idx = stack.pop();
                // 要有高度差 才能收集
                while (!stack.isEmpty() && height[idx] == height[stack.peek()]) {
                    stack.pop();
                }
                // 开始收集
                if (!stack.isEmpty()) {
                    int left = height[stack.peek()];
                    // 此时i没有入栈 相当于在它的右边
                    int right = height[i];
                    int high = Math.min(left, right) - height[idx];
                    int width = i - stack.peek() - 1;
                    ret += high * width;
                }
            }
            // 构建单调递减的栈
            stack.push(i);
        }
        return ret;
    }
}
