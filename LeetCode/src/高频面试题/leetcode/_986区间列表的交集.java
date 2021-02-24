package 高频面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _986区间列表的交集 {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        if (a.length == 0 || b.length == 0) {
            return new int[][]{};
        }
        int n = a.length, m = b.length;
        List<int[]> res = new ArrayList<>();
        for (int i = 0, j = 0; i < n && j < m;) {
            // 左边取大
            int start = Math.max(a[i][0], b[j][0]);
            // 右边取小
            int end = Math.min(a[i][1], b[j][1]);
            // 有交集
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            // 求完一个交集区间后，较早结束的子区间
            // 不可能再和别的子区间有重叠，它的指针要移动。
            if (a[i][1] < b[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        /**
         *  the array into which the elements of this list are to be stored, if it is big enough;
         *  otherwise, a new array of the same runtime type is allocated for this purpose.
         *  简单来说里面写需要转成的类型的数组
         */
        return res.toArray(new int[0][0]);
    }

}
