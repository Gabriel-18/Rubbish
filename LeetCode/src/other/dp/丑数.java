package other.dp;

//
public class 丑数 {
//    用一个数组，三个指针，index2,index3 和 index5,
//    给每个元素乘以 2,3,5 看哪个刚好比当前 nextindex 位置的元素大，就放进来
//    因此我们可以创建一个数组，里面的数字是排好序的丑数，每一个丑数都是前面的丑数乘以2 3 或者5 得到的。


    public int GetUglyNumber_Solution(int N) {
        if (N <= 6)
            return N;
        int i2 = 0, i3 = 0, i5 = 0;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
//            #计算M2,M3,M5中最小的数做为下一个丑数
            int next2 = dp[i2] * 2, next3 = dp[i3] * 3, next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            if (dp[i] == next2)
                i2++;
            if (dp[i] == next3)
                i3++;
            if (dp[i] == next5)
                i5++;
        }
        return dp[N - 1];
    }

}