package other.arrays;

public class 数组中重复的数字 {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false


    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
        for (int i = 0; i < nums.length; i++) {
            // 不符合题目要求
            if (nums[i] != i) {
                // 必然重复
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            // 没有重复的情况 都会有交换行为
            while (numbers[i] != i) {
                // 必然重复的情况
                // 后面存在重复的数
                if (numbers[i] == numbers[numbers[i]]) {
                    // 保存结果
                    // 并且返回
                    duplication[0] = numbers[i];
                    return true;
                }
                // 没有重复的情况 都会有交换行为
                // 通过交换制造重复
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
