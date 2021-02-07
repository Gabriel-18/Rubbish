package 剑指offer;
// 很多编程语言都有用到 ^。
// 其可代表幂、逻辑异或 (XOR) 运算符、字符串串接、以 脱字符表示法来表达控制字符等等。
// a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
public class 不用加减乘除做加法 {
    public int Add(int num1,int num2) {
        return num2 == 0 ? num1 
                : Add(num1 ^ num2,(num1 & num2) << 1);
    }
}
