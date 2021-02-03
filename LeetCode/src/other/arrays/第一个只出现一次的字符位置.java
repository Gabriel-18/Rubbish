package other.arrays;

public class 第一个只出现一次的字符位置 {
    public int FirstNotRepeatingChar(String str) {
        int[] cnt = new int[128];
        for (int i = 0; i < str.length(); i++)
            cnt[str.charAt(i)]++;

        for (int i = 0; i < str.length(); i++)
            if (cnt[str.charAt(i)] == 1)
                return i;
        return -1;
    }


    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        // 题目说了只有小写字母
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }


}
