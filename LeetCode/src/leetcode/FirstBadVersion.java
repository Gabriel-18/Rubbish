package leetcode;

public class FirstBadVersion {
    /**
     * https://leetcode.com/problems/first-bad-version/description/
     * 278. First Bad Version
     * 寻找第一个满足某条件的元素的位置
     * 经典问题
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int l = 0, h = n;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}
