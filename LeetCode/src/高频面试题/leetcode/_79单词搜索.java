package 高频面试题.leetcode;

public class _79单词搜索 {
    private int[][] next = {{1,0}, {-1,0},{0,1},{0,-1}};
    private int m;
    private int n;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(0,i,j,marked,board,word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(int curLen, int r, int c,boolean [][]marked, char[][] board, String word) {
        if (curLen == word.length()) {
            return true;
        }

        if (r < 0 || r >= m || c < 0 || c >= n ||
                board[r][c] != word.charAt(curLen) || marked[r][c]) {
            return false;
        }

        marked[r][c] = true;

        for (int[] d : next) {
            if (backtracking(curLen + 1, r + d[0], c + d[1], marked, board, word)) {
                return true;
            }
        }

        marked[r][c] = false;
        return false;
    }
}
