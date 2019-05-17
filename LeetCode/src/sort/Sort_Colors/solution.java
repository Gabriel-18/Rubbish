package sort.Sort_Colors;

/***
 * https://leetcode.com/problems/sort-colors/description/
 * 荷兰国旗包含三种颜色：红、白、蓝。
 *
 * 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。
 *
 * 它其实是三向切分快速排序的一种变种，在三向切分快速排序中，
 * 每次切分都将数组分成三个区间：小于切分元素、等于切分元素、大于切分元素，而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色
 */
public class solution {
    public void sortColors(int[] nums) {
        int zreo = -1, one = 0, two = nums.length;
        /**
         * 画图
         */
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zreo, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                ++ one;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;

    }
}
