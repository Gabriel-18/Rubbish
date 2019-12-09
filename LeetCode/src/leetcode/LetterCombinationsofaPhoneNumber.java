package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
 */
public class LetterCombinationsofaPhoneNumber {
    // 建立映射表
    private String letterMap[] = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    // 保存结果
    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if (digits.equals("") ){
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            // 到达最底层
            res.add(s);
            return;
        }
        // recursive rule
        Character c = digits.charAt(index);

        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i ++) {
            // 下一层
            findCombination(digits, index  + 1, s + letters.charAt(i));
        }
        return;
    }

}
