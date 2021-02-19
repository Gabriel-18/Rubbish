package 高频面试题.leetcode;
// 交换策略
// 高位要是能换一个最大的血赚
// 所以从低位开始记录右边最大的数的索引
public class _670最大交换 {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        int[] index_arr = new int[nums.length];
        int max_index = nums.length - 1;
        //低位往高位遍历
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] > nums[max_index]) {
                max_index = i;
            }
            index_arr[i] = max_index;
        }
        //高位往低位遍历
        for (int i = 0; i < nums.length; i++) {
            // 交换
            if (nums[i] != nums[index_arr[i]]) {
                char temp = nums[i];
                nums[i] = nums[index_arr[i]];
                nums[index_arr[i]] = temp;
                break;
            }
        }
        //  Parses the string argument as a signed decimal integer.
//        return Integer.parseInt(new String(nums));
        return Integer.parseInt(new String(nums));
    }
}
