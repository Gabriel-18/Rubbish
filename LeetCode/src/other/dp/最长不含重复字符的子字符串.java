package other.dp;

import java.util.Arrays;


//主要思路：使用动态规划，记录当前字符之前的最长非重复子字符串长度 f (i-1)，其中 i 为当前字符的位置。每次遍历当前字符时，分两种情况：
//
//1）若当前字符第一次出现，则最长非重复子字符串长度 f (i) = f (i-1)+1。
//2）若当前字符不是第一次出现，则首先计算当前字符与它上次出现位置之间的距离 d。若 d 大于 f (i-1)，
// 即说明前一个非重复子字符串中没有包含当前字符，则可以添加当前字符到前一个非重复子字符串中，所以，f (i) = f (i-1)+1。
// 若 d 小于或等于 f (i-1)，即说明前一个非重复子字符串中已经包含当前字符，则不可以添加当前字符，所以，f (i) = d。
//————————————————

public class 最长不含重复字符的子字符串 {
    public int longestSubStringWithoutDuplication(String str) {
        int curLen = 0;
        int maxLen = 0;
        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = preIndexs[c];
            //当前字符与它上次出现位置之间的距离
            // curI - preI
            //当前字符第一次出现，或者前一个非重复子字符串中没有包含当前字符
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            } else {
                //更新最长非重复子字符串的长度
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }
            //更新字符出现的位置
            preIndexs[c] = curI;
        }
        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }

}
