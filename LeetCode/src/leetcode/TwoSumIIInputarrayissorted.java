package leetcode;

public class TwoSumIIInputarrayissorted {
    /**
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     * 167. Two Sum II - Input array is sorted
     * 有序
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i ++;
            } else {
                j --;
            }
        }
        return null;
    }
}
