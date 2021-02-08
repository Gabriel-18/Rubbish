package leetcode.sort;

public class _75颜色分类 {
    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) { // 小于区域
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) { // 大于区域
                //因为把当前nums[one]和 >区的左边界的前边的1个值(也就是arr[two])做了交换
                //但是nums[two]还没有被判断过，所以这里one不能+1
//                还要检查互换以后的nums[i]位置是否正确，向后换不用检查，因为for循环还会遍历到
//                可能的一种情况是nums[p2]等于0，所以交换后不能让i+1，进入下一步判断nums[i]是不是0
                swap(nums, --two, one);
            } else {
                // nums[one] == 1
                ++one;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
