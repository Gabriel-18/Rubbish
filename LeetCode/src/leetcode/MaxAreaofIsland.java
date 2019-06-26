package leetcode;

public class MaxAreaofIsland {
    /**
     * 695. Max Area of Island
     * https://leetcode.com/problems/max-area-of-island/description/
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * @param grid
     * @return
     */
    private int m, n;
    private int[][] direction = {{0, 1} ,{0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 判断是否越界
        if (r < 0 || r >= m || c >= n || c < 0 || grid[r][c] == 0) {
            return 0;
        }
        // 已经被访问过了 不能往回走
        grid[r][c] = 0;
        // 一个点自身面积代表1
        int area = 1;
        // 分别向右左上下
        for (int[] d : direction) {
            area += dfs(grid, r + d[0], c + d[1]);
        }
        return area;
    }
}
