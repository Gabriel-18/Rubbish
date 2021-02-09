package 高频面试题.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
public class _15三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        //排序 + 双指针
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return ans;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                //去重
                continue;
            }
            //双指针
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                }else if (nums[i] + nums[l] + nums[r] > 0) {
                    //需要左移
                    r--;
                }else {
                    l++;
                }
            }
        }
        return ans;
    }
}

