package graph;

import java.util.Stack;

public class DepthFirstPaths {
    /**
     * 这个顶点上调用过dfs()吗
     */
    private boolean[] marked;
    /**
     * 从起点到一个顶点的已知路径上最后一个顶点
     */
    private int[] edgeTo;
    /**
     * 起点
     */
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        //添加起点
        path.push(s);
        return path;
    }
}
