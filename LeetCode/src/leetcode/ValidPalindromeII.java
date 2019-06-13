package leetcode;

public class ValidPalindromeII {
    /**
     * 680. Valid Palindrome II
     * https://leetcode.com/problems/valid-palindrome-ii/description/
     * 题意是可以删除一个字符然后形成回文串
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1;i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                // 两种可能性
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
