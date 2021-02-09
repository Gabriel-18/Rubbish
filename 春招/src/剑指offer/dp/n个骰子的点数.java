package 剑指offer.dp;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//1. 现在变量有：骰子个数，点数和。当有 c 个骰子，点数和为 k 时，出现次数记为 dp (c,k)。那与 c-1 个骰子阶段之间的关系是怎样的？
//2. 当我有 c-1 个骰子时，再增加一个骰子，这个骰子的点数只可能为 1、2、3、4、5 或 6。那 k 个骰子得到点数和为 n 的情况有：
// (c-1,k-1)：第c个骰子投了点数1
//(c-1,k-2)：第c个骰子投了点数2
//(c-1,k-3)：第c个骰子投了点数3
//....
//(c-1,k-6)：第c个骰子投了点数6
// 在 c-1 个骰子的基础上，再增加一个骰子出现点数和为 k 的结果只有这 6 种情况！
//所以：dp (c,k)=dp (c-1,k-1)+dp (c-1,k-2)+dp (c-1,k-3)+dp (c-1,k-4)+dp (c-1,k-5)+dp (c-1,k-6)(注意当 k<6 时的处理越界问题)
//3. 有 1 个骰子，dp (1,1)=dp (1,2)=dp (1,3)=dp (1,4)=dp (1,5)=dp (1,6)=1
//dp[c][k]=sum（dp[c-1][k-m]）(1<=m<=6&&m<k)


//假设 f (m,n) 表示投第 m 个骰子时，点数之和 n 出现的次数，投第 m 个骰子时的点数之和只与投第 m-1 个骰子时有关。
//
//递归方程：f (m,n)=f (m-1,n-1)+f (m-1,n-2)+f (m-1,n-3)+f (m-1,n-4)+f (m-1,n-5)+f (m-1,n-6)，表示本轮点数和为 n 出现次数等于上一轮点数和为 n-1，n-2，n-3，n-4，n-5，n-6 出现的次数之和。
//
//初始条件：第一轮的 f (1),f (2),f (3),f (4),f (5),f (6) 均等于 1.
public class n个骰子的点数 {
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        final int face = 6;
        final int pointNum = face * n;
        //首先为了方便表达，我们将 dp 数组的行的数量设为 n + 1，列的数量设为 6n + 1。
        // 行表示 n，列表示 s，且 s 的最大值是 6n。
        //首先假如只有一个骰子（n = 1），s 的范围是 [n, 6n]，
        // 所以 s 的范围是 [1, 6]，且 s 的每个值可能出现的次数都为 1。

        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++)
            dp[1][i] = 1;

        for (int i = 2; i <= n; i++)
            // 注意 j 从 i 开始，因为 j 的最小值为 i
            // 比如掷 3 个骰子，s 最小为 3
            for (int j = i; j <= pointNum; j++)     /* 使用 i 个骰子最小点数为 i */
                // 边界
                for (int k = 1; k <= face && k <= j; k++)
                    dp[i][j] += dp[i - 1][j - k];

        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = n; i <= pointNum; i++)
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));

        return ret;
    }

}
