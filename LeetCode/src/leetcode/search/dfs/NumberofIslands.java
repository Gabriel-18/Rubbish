package leetcode.search.dfs;

/**
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 */
public class NumberofIslands {
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int islandsNum = 0;
        // 出发点多个
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 可搜索的前提 才开始搜索
                if (grid[i][j] != '0') {
                    dfs(grid, i, j);
                    // 统计个数 执行了多少次
                    // 多少个可出发点
                    islandsNum++;
                }

            }
        }
        return islandsNum;
    }
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        // 标记已访问
        grid[i][j] = '0';

        for (int[] d : direction) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
