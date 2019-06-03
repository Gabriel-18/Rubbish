package leetcode;

import java.util.Stack;

public class DailyTemperatures {
    /***
     * https://leetcode.com/problems/daily-temperatures/
     * 739. Daily Temperatures
     * 先处理暂时能处理的数字
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] dist = new int[n];
        // 存放index
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            //如果当前遍历的数比栈顶元素来的大，
            // 说明栈顶元素的下一个比它大的数就是当前元素。
            while (!indexs.isEmpty() && T[curIndex] > T[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            // 只放不比栈顶大的
            indexs.add(curIndex);
        }
        return dist;
    }
}
