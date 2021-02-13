package 高频面试题.leetcode;

public class _200岛屿数量 {
    private int[][] next = {{0,1},{0,-1},{1,0},{-1,0}};
    private int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (grid == null || m == 0 || n == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }

            }
        }
        return num;
    }

    private void dfs(char[][] grid, int r, int c) {
        // 顺序很重要
        // || 具有短路的效果
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';

        for (int[] n : next) {
            dfs(grid, r + n[0], c + n[1]);
        }

    }
}
