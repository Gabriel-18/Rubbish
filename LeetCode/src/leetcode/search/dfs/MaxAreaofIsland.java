package leetcode.search.dfs;

public class MaxAreaofIsland {
    /**
     * 695. Max Area of Island
     * https://leetcode.com/problems/max-area-of-island/description/
     * grid数组被初始化过的
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
    // 设为全局变量
    private int m, n;
    // 向量数组 描述方向
    private int[][] next = {{0, 1} ,{0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        // 预处理
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 矩阵信息
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;

        // 不断更新
        // 更新出发点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 判断是否越界
        // 不能访问
        if (r < 0 || r >= m || c >= n || c < 0 || grid[r][c] == 0) {
            return 0;
        }
        // 已经被访问过了 不能往回走
        // 对已经遍历过的节点进行标记
        grid[r][c] = 0;
        // 一个点自身面积代表1
        int area = 1;
        // 分别向右左上下
        for (int[] d : next) {
            area += dfs(grid, r + d[0], c + d[1]);
        }
        System.out.println(area);
        return area;
    }
}
