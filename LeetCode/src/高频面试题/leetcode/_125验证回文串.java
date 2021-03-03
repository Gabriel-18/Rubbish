package 高频面试题.leetcode;

public class _125验证回文串 {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] chs = s.toCharArray();
        while (left < right) {
            if (!Character.isLetterOrDigit(chs[left])){
                left++;
            } else if (!Character.isLetterOrDigit(chs[right])){
                right--;
            } else if (Character.toLowerCase(chs[left++]) != Character.toLowerCase(chs[right--])){
                return false;
            }
        }
        return true;
    }
}
