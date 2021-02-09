package 剑指offer.search;

public class 机器人的运动范围 {
    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        // 出发点固定了
        dfs(marked, 0, 0);
        return cnt;
    }

    // 搜索
    private void dfs(boolean[][] marked, int r, int c) {
//        边界
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
            return;
//        标记
        marked[r][c] = true;
//        if (this.digitSum[r][c] > this.threshold)
        // 不符合题意
        if (check(r) + check(c) > this.threshold)
            return;
        // 步数加1
        cnt++;
        // 搜索
        for (int[] n : next)
            dfs(marked, r + n[0], c + n[1]);
    }

    // 算下前缀和
    private int check(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
    // 预先存储每一个位置代表的值
    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.cols; j++)
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
    }
}
