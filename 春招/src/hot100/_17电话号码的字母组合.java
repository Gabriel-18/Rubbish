package hot100;

import java.util.ArrayList;
import java.util.List;

public class _17电话号码的字母组合 {
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        // 0 1没有对应 所以用空串
        String[] s = {"","","ad","ae","af","bd","be","bf","cd","ce","cf"};
        backTracking(digits,s,0);
        return list;
    }

    StringBuffer temp = new StringBuffer();
    private void backTracking(String digits, String[] s, int num) {
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        String str = s[digits.charAt(num) - '0'];

        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, s, num + 1);
            temp.deleteCharAt(temp.length() - 1);
        }

    }
}
