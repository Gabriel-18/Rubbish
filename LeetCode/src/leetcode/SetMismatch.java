package leetcode;

import java.util.Arrays;

public class SetMismatch {
    /**
     * https://leetcode.com/problems/set-mismatch/description/
     * 645. Set Mismatch
     */
    /**
     * brute force
     * but we can stop in advance
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int dup = -1, missing = -1;
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }
                if (count == 2) {
                    dup = i;
                } else if (count == 0) {
                    missing = i;
                }
                if (dup > 0 && missing > 0) {
                    break;
                }
            }
        return new int[] {dup, missing};
    }
    public int[] findErrorNums2(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for(int i = 1; i <= nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dup = nums[i];
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1;
            }

            // 最后一个边界 不好发现啊 这种做法不安全
            if (nums[nums.length - 1] != nums.length) {
                missing = nums.length;
            }
        }
        return new int[] {dup,  missing};
    }
}
