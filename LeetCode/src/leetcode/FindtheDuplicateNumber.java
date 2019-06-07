package leetcode;

public class FindtheDuplicateNumber {
    /**
     * https://leetcode.com/problems/find-the-duplicate-number/description/
     * 287. Find the Duplicate Number
     * 我们比较的 mid 而不是 nums[mid]
     * 因为 mid 是下标，所以判断式应为 cnt > mid，最后返回 min
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int cnt = 0;
            for (int i = 0;i < nums.length; i++) {
                if (nums[i] <= mid) {
                    cnt ++;
                }
            }
            // 前半部分有重复的
            if (cnt > mid) {
                max = mid - 1;
            } else {
                // 后半部分有重叠的
                min = mid + 1;
            }
        }
        return min;
    }
}
