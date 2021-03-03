package 高频面试题.leetcode;

public class _34在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 ) {
            return new int[] {-1,-1};
        }
        int l = findFirst(nums, target);
        if (l == -1) {
            return new int[] {-1,-1};
        }
        int r = findLast(nums, target);
        return new int[]{l,r};

    }

    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }



    private int findLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
