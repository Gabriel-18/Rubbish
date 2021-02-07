package leetcode.二分查找;

/**
 * 奇数长度的数组首尾元素索引都为偶数，因此我们可以将 lo 和 hi 设置为数组首尾。
 * 我们需要确保 mid 是偶数，如果为奇数，则将其减 1。
 * 然后，我们检查 mid 的元素是否与其后面的索引相同。
 * 如果相同，则我们知道 mid 不是单个元素。且单个元素在 mid 之后。则我们将 lo 设置为 mid + 2。
 * 如果不是，则我们知道单个元素位于 mid，或者在 mid 之前。我们将 hi 设置为 mid。
 * 一旦 lo == hi，则当前搜索空间为 1 个元素，那么该元素为单个元素，我们将返回它。
 * 1,1,2,3,3 4 4
 * 0 1 2 3 4 5 6
 *
 * 要求以 O(logN) 时间复杂度进行求解，因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为 O(N)。
 *
 * 令 index 为 Single Element 在数组中的位置。在 index 之后，数组中原来存在的成对状态被改变。
 *
 * 如果 m 为偶数，并且 m + 1 < index，那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
 *
 * 从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为 [m + 2, h]，此时令 l = m + 2；
 *
 * 如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
 *
 * 因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。
 */
public class _540有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                //nums[m] != nums[m + 1]
                h = m;
            }
        }
        return nums[l];
    }
}
