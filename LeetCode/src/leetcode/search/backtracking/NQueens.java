package leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    private List<List<String>> solutions;
    private char[][] nQueens;
    private boolean[] col;
    private boolean[] dg;
    private boolean[] udg;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
//            Arrays.fill(nQueens[i], '.');

        }
        col = new boolean[n];
        dg = new boolean[2 * n - 1];
        udg = new boolean[2 * n - 1];
        this.n = n;
        backtracking(0);
        return solutions;
    }

    private void backtracking(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : nQueens) {
                list.add(new String(chars));
            }
            solutions.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            int dgIdx = row + col;
            int udgIdx = n - 1 - (row - col);
            if (this.col[col] || dg[dgIdx] || udg[udgIdx]) {
                continue;
            }
            nQueens[row][col] = 'Q';
            this.col[col] = dg[dgIdx] = udg[udgIdx] = true;
            backtracking(row + 1);
            this.col[col] = dg[dgIdx] = udg[udgIdx] = false;
            nQueens[row][col] = '.';
        }
    }


}
