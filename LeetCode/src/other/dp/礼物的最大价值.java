package other.dp;

//  [1,3,1],0 1 4 5
//  [1,5,1],1 2 9 10
//  [4,2,1],2 6 11 12

/**
 *
 0 1
 value3
 dp1 0 dp0+ value1 4
 1 dp 4
 value1
 dp2 0 dp1+ value2 5
 1 dp 5

 1 2
 value5
 dp1 4 dp0+ value1 7
 2 dp 9
 value1
 dp2 5 dp1+ value2 10
 2 dp 10

 2 6
 value2
 dp1 9 dp0+ value1 8
 3 dp 11
 value1
 dp2 10 dp1+ value2 12
 3 dp 12

 */

public class 礼物的最大价值 {
    public int getMost(int[][] values) {
        // 边界判断
        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }
        int n = values[0].length;
        int[] dp = new int[n];
        int count = 0;
        for (int[] value : values) {

            dp[0] += value[0];
//            System.out.println(count + " " +dp[0]);
//            count++;
            for (int i = 1; i < n; i++) {
//                System.out.println("dp" + i +" " +dp[i] + "dp"+ (i-1) + "value"+i + " " + dp[i-1] + value[i]);
                dp[i] = Math.max(dp[i], dp[i-1] + value[i]);

//                System.out.println(count + " " +"dp" + " " +dp[i]);
            }

        }
        return dp[n-1];
    }
}
