package 高频面试题.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _349两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            if(set1.contains(i)){
                set2.add(i);
            }
        }
        int[] arr = new int[set2.size()];
        int j=0;
        for(int i:set2){
            arr[j++] = i;
        }
        return arr;
    }
}
