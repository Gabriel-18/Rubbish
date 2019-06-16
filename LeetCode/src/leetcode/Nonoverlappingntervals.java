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
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int cnt = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length - cnt;
    }
}
