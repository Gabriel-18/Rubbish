package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Nonoverlappingntervals {
    /**
     * 435. Non-overlapping Intervals
     * https://leetcode.com/problems/non-overlapping-intervals/description/
     * 注意数据
     * intervals[i][0]代表start
     * intervals[i][1]代表end
     * 然后统计就行了
     * 重点是读懂题目
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //在每次选择中，区间的结尾最为重要，选择的区间结尾越小，留给后面的区间的空间越大，
        // 那么后面能够选择的区间个数也就越大。
        // 关于这个接口的使用不会
        //Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];//升序
            }
        });
        int cnt = 1;
        // 第一个结尾
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // 判断有没有重叠 就是看当前开始的位置是否比上一个结尾小
            if (intervals[i][0] < end) {
                continue;
            }
            //发现重叠 更新结尾
            end = intervals[i][1];
            // 更新计数
            cnt++;
        }
        // 返回去掉的重叠数即为答案
        return intervals.length - cnt;
    }
}
