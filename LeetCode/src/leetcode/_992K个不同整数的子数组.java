package leetcode;

import java.util.Arrays;

public class _992K个不同整数的子数组 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] lower = new int[n], upper = new int[n];
        find(lower, nums, k);
        find(upper, nums, k - 1);
        System.out.println(Arrays.toString(lower));
        System.out.println(Arrays.toString(upper));
        int ans = 0;
        for (int i = 0; i < n; i++) ans += upper[i] - lower[i];
        return ans;
    }

    private void find(int[] arr, int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];//窗口信息，判断每个元素的重复次数
        int ans = 0;
        for (int i = 0, j = 0, sum = 0; i < n; i++) {
            int right = nums[i];
            if (cnt[right] == 0) {
                sum++;//找不同
            }
            cnt[right]++;
            while (sum > k) {//当刚好不满足条件时（即满足k+1时进行左坐标寻找）
                int left = nums[j++];
                cnt[left]--;
                if (cnt[left] == 0) {
                    sum--;//当刚好不满足条件跳出，即i刚好满足k+1的位置为j
                }
            }
            arr[i] = j;//位置i向左刚好不满足条件时的位置是j
        }
    }

}
