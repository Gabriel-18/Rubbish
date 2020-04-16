package leetcode.tree;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        // 将不为0的数 按照顺序放到前面
        // 后面的部分自然就是为0
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
