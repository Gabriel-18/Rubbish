package leetcode;

public class FindSmallestLetterGreaterThanTarget {
    /**
     * 744. Find Smallest Letter Greater Than Target
     * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) l = m + 1;
            else h = m;
        }
        return letters[l % letters.length];
    }


    public char nextGreatestLetter2(char[] letters, char target) {
        int l = 0, n = letters.length;
        int h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else  {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
}
