package leetcode;

public class MoveZeroes {
    /**
     * 283. Move Zeroes
     * https://leetcode.com/problems/move-zeroes/
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[idx++] = num;
            }
        }
        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
