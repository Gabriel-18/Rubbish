package leetcode.search.dfs;
//从边界出发吧，先把边界上和 O 连通点找到, 把这些变成 T,
// 然后遍历整个 board 把 O 变成 X, 把 B 变成 O
//X X X X
//X O O X
//X X O X
//X O X X  =>
//
//X X X X
//X X X X
//X X X X
//X O X X
public class SurroundedRegions {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        m = board.length;
        n = board[0].length;

//       先把外面的0涂成T，
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
//      然后遍历整个board把0都涂成X，把T涂成0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return;
        }
        // 可以
        board[r][c] = 'T';
        for (int[] d : direction) {
            dfs(board, r + d[0], c + d[1]);
        }
    }

}
