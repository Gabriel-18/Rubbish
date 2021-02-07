package leetcode.二分查找;

public class _744寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (letters[m] > target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return letters[l] > target ? letters[l] : letters[0];
    }
}
