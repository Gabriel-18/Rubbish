package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsnaString {
    /**
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/#/description
     * 散列 消除顺序
     * 感觉意义不大
     * 白写了一个小时
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int l = p.length();


        ArrayList<Integer> ans = new ArrayList<>();
        int[] vp = new int[26];
        int[] vs = new int[26];
        // 模式
        for (char c : p.toCharArray()) {
            //++vp[c - 'a'];
            vp[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (i >= l) {
                //-- vs[s.charAt(i - l) - 'a'] ;
                //去掉之前头部的消息
                // i - l + 1是当前头节点
                // i - l是之前的头
                vs[s.charAt(i - l) - 'a']-- ;
            }
           //++ vs[s.charAt(i) - 'a'];
           vs[s.charAt(i) - 'a']++;
            //判断是否匹配
            if (Arrays.equals(vs, vp)) {
                ans.add(i + 1 - l);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = findAnagrams("cbaebabacd",
                "abc");
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }
    }
}
