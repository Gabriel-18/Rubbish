package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
 */
public class LetterCombinationsofaPhoneNumber {
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
            res.add(s);
            return;
        }
        Character c = digits.charAt(index);

        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i ++) {
            findCombination(digits, index  + 1, s + letters.charAt(i));
        }
        return;
    }

}
