package leetcode.dp;

/**
 * PS. 这里的状态定义我是猜的，这其实是个技巧。通常我们做 DP 题，都
 * 是先猜一个定义，然后看看这个定义是否能分析出状态转移方程帮助我们「不重不漏」的枚举所有的方案。
 * 一般我是直接根据答案来猜定义，这里是求最长子数组长度，
 * 所以我猜一个 f(i,j) 代表最长湍流子数组长度
 *
 *
 * arr[i - 1] < arr[i]：该点是由上升而来，能够「接着」的条件是 i - 1 是由下降而来。则有：f[i][0] = f[i - 1][1] + 1
 * arr[i - 1] > arr[i]：改点是由下降而来，能够「接着」的条件是 i - 1 是由上升而来。则有：f[i][1] = f[i - 1][0] + 1
 * arr[i - 1] = arr[i]：不考虑，不符合「湍流」的定义
 *

 *

 */
public class _978最长湍流子数组 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ans = 1;
        //我们定义 f(i,j) 代表以位置 i 为结尾，
        // 而结尾状态为 j 的最长湍流子数组长度（0：上升状态 / 1:下降状态）
        int[][] f = new int[n][2];
        for (int i = 0; i < 2; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) f[i][j] = 1;
            if (arr[i - 1] < arr[i]) {
                f[i][0] = f[i - 1][1] + 1;
            }
            if (arr[i - 1] > arr[i]) {
                f[i][1] = f[i - 1][0] + 1;
            }
            for (int j = 0; j < 2; j++) {
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }

    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int n = arr.length;
            int ans = 1;
            int[][] f = new int[2][2];
            for (int i = 0; i < 2; i++) {
                f[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    f[i % 2][j] = 1;
                }
                if (arr[i - 1] < arr[i]) {
                    f[i % 2][0] = f[(i - 1) % 2][1] + 1;
                }

                if (arr[i - 1] > arr[i]) {
                    f[i % 2][1] = f[(i - 1) % 2][0] + 1;
                }
                for (int j = 0; j < 2; j++) {
                    ans = Math.max(ans, f[i % 2][j]);
                }
            }
            return ans;
        }
    }

//当我们要转移第 i 行的时候，f 数组装的就已经是 i - 1 行的结果
    class Solution2 {
        public int maxTurbulenceSize(int[] arr) {
            int n = arr.length;
            int ans = 1;
            int[] f = new int[2];
            for (int i = 0; i < 2; i++) {
                f[i] = 1;
            }
            for (int i = 1; i < n; i++) {
                int dp0 = f[0], dp1 = f[1];
                if (arr[i - 1] < arr[i]) {
                    f[0] = dp1 + 1;
                } else {
                    f[0] = 1;
                }
                if (arr[i - 1] > arr[i]) {
                    f[1] = dp0 + 1;
                } else {
                    f[1] = 1;
                }
                for (int j = 0; j < 2; j++) {
                    ans = Math.max(ans, f[j]);
                }
            }
            return ans;
        }
    }



}
