package other;

import java.util.Arrays;

public class 把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        int n = numbers.length;
        String[] nums = new String[n];
        // 字符串化
        for (int i = 0; i < n; i++) {
            nums[i] = numbers[i] + "";
        }
        // s1 + s2 < s2 + s1
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String ret = "";
        for (String str : nums) {
            ret += str;
        }
        return ret;
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "321";
        // 123321 < 321123
        int i = (a + b).compareTo(b + a);
        String[] nums = {"123","456" };
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        System.out.println(nums);
        Arrays.sort(nums, (s2, s1) -> (s1 + s2).compareTo(s2 + s1));
        System.out.println(nums);

    }
}
