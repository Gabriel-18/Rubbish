package leetcode.search.dfs;
/*
[1,1,0],
[1,1,0],
[0,0,1]
https://leetcode-cn.com/problems/number-of-provinces/
 */
public class FriendCircles {
    private int n;
    public int findCircleNum(int[][] M) {
        n = M.length;
        int circleNum = 0;
        //表示哪些城市被访问过
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            //如果当前城市没有被访问过，说明是一个新的省份，count
            //要加1，并且和这个城市相连的都标记为已访问过，也就是
            //同一省份的
            if (!hasVisited[i]) {
                dfs(M, i, hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

//    private void dfs(int[][] M, int i, boolean[] hasVisited) {
//        hasVisited[i] = true;
//        for (int  k = 0; k < n; k++) {
//            if (M[i][k] == 1 && !hasVisited[k]) {
//                dfs(M, k, hasVisited);
//            }
//        }
//    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int  k = 0; k < n; k++) {
            //如果第i和第k个城市相连，说明他们是同一个省份的，把它标记为已访问过
            if (M[i][k] == 1 && !hasVisited[k]) {
                // 然后继续查找和第k个城市想连的城市
                dfs(M, k, hasVisited);
            }
        }
    }
}
