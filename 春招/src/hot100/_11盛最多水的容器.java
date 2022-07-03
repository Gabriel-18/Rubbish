package hot100;

public class _11盛最多水的容器 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                res = Math.max(res, (r - l) * height[l]);
                l++;
            } else if (height[l] >= height[r]) {
                res = Math.max(res, (r - l) * height[r]);
                r++;
            }
        }
        return res;
    }
}
