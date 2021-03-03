package 高频面试题.leetcode.补充题;

import org.junit.Test;

public class _36进制加法 {
    char getChar(int n)
    {
        if (n <= 9)
            return (char) (n + '0');
        else
            return (char) (n - 10 + 'a');
    }

    int getInt(char ch)
    {
        if ('0' <= ch && ch <= '9')
            return ch - '0';
        else
            return ch - 'a' + 10;
    }
    String add36Strings(String num1, String num2)
    {
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        int x, y;
        StringBuilder res = new StringBuilder("");
        while (i >= 0 || j >= 0)
        {
            x = i >= 0 ? getInt(num1.charAt(i)) : 0;
            y = j >= 0 ? getInt(num2.charAt(j)) : 0;
            int temp = x + y + carry;
            carry = temp / 36;
            res.append(getChar(temp % 36));
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }

    @Test
    public void test() {
        String a = "1b", b = "2x", c;

        c = add36Strings(a, b);
        System.out.println(c);
    }
}
