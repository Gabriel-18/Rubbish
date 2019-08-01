package leetcode;

public class ValidPalindromeII {
    /**
     * 680. Valid Palindrome II
     * https://leetcode.com/problems/valid-palindrome-ii/description/
     * 题意是可以删除一个字符然后形成回文串
     *
     * Suppose we want to know whether s[i], s[i+1], ..., s[j] form a palindrome.
     * If i >= j then we are done.
     * If s[i] == s[j] then we may take i++; j--.
     * Otherwise, the palindrome must be either s[i+1], s[i+2], ..., s[j]
     * or s[i], s[i+1], ..., s[j-1],
     * and we should check both cases.
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
