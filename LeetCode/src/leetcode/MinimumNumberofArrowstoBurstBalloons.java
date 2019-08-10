package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {
    /**
     * 452. Minimum Number of Arrows to Burst Balloons
     * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
     * 计算不重叠区间
     * 有多少个重叠区间就需要射多少次
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 从结尾结尾下的开始
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));//升序
        int cnt = 1, end = points[0][1];
        // 统计重叠区间
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
