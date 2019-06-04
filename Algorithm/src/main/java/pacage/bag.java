package pacage;

public class bag {
    int w = 6;
    int num = 5;

    public int[][] relsult = new int[5][5];
    public static int[][] dp = new int[6][7];
    public static int[] weights = new int[]{3,2,1,4,5};
    public static int[] values = new int[]{25,20,15,40,50};

    public static void main(String[] args) {

        System.out.println(knapsack(6, 5, weights,values));
    }

    public static int knapsack(int W, int N, int[] weights, int[] values) {
        dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1], v = values[i - 1];
            for (int j = 1; j <= W; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[N][W];
    }


}
