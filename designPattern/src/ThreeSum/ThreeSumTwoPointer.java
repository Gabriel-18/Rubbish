package ThreeSum;

import java.util.Arrays;

/**
 * 更有效的方法是先将数组排序
 * 然后使用双指针进行查找，时间复杂度为 O(N2)。
 */
public class ThreeSumTwoPointer implements ThreeSum {

    @Override
    public int count(int[] nums) {
        int N = nums.length;
        int cnt = 0;
        Arrays.sort(nums);//猜测O(lgn)
        //O(n^2)
        for (int i = 0; i < N - 2; i++) {
            int l = i + 1, h = N - 1, target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (l < h) {
                int sum = nums[l] + nums[h];
                if (sum == target) {
                    cnt++;
                    //去重
                    while (l < h && nums[l] == nums[l + 1]) l++;
                    while (l < h && nums[h] == nums[h - 1]) h--;
                    l++;
                    h--;
                } else if (sum < target) {
                    //右移
                    l++;
                } else {
                    //左移
                    h--;
                }
            }
        }
        return cnt;
    }
}
