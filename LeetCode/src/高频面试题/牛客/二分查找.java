package 高频面试题.牛客;

public class 二分查找 {
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int l = 0, r = n - 1;
        // 特判
        if (v > a[n-1]) {
            return n + 1;
        }
        // 右边界模板
        while (l < r) {
            int mid = (l + r) >> 1;
            if (a[mid] >= v) r = mid;
            else l = mid + 1;
        }
        return l + 1;
    }
}
