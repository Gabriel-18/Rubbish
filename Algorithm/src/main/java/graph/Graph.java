package graph;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    /**
     * 顶点数
     */
    private final int V;
    /**
     * 边数
     */
    private int E;
    /**
     * 邻接表
     */
    private Set<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Set[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<>();
        }
    }

    public int V(){
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 无向图边重复
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Set<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = V + "vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
