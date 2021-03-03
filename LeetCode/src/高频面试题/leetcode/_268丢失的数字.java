package 高频面试题.leetcode;

public class _268丢失的数字 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i] ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 2 ^ 1);
    }
}
