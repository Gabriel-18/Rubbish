package leetcode;

/**
 * https://leetcode.com/problems/powx-n/description/
 * // 当n为负数时 可能会溢出 负数的范围永远比正数大1
 * // 解决方案大致两种 1.强转 2.自己手动算一次
 */
public class Pow {
    public static double myPow(double x, int n) {
        //if (n == 0) {
        //    return 1;
        //} else if (n < 0) {
        //    //多写一层就没问题了?????? 防止溢出
        //    //return 1 / x  / myPow(x, -(n + 1));
        //    return 1 / myPow(x, -(n));
        //} else if (n % 2 ==1 ){
        //    return x * myPow(x, n - 1);
        //}
        //return myPow(x * x, n /2);

        //为什么不耐操
        //if(n<0) return 1/x * myPow(1/x, -(n+1));
        //if(n==0) return 1;
        //if(n==2) return x*x;
        //if(n%2==0) return myPow( myPow(x, n/2), 2);
        //else return x*myPow( myPow(x, n/2), 2);
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1.0 / pow(x, n);
        }
    }
    public static double myPow2(double x, int n) {
        double res = 1;
        if (n == 0) {
            return 1;
        }
        // 防止溢出
        // 当n为负数时 可能会溢出 负数的范围永远比正数大1
        // 解决方案大致两种 1.强转 2.自己手动算一次
        long abs = Math.abs(n);
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }
    private static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return  y * y;
        } else {
            return y * y * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(1.00000 ,-2147483648));
    }
}
