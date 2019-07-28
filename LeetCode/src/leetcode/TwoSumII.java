package leetcode;

public class TwoSumII {
    /**
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
     * 167. Two Sum II - Input array is sorted
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0 , j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i+1, j+1};
            } else if (numbers[i] + numbers[j] > target) {
                 j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
