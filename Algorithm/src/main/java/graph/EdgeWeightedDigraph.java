package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 加权有向图
 */
public class EdgeWeightedDigraph {
    /**
     * 顶点总数
     */
    private  int V;
    /**
     * 边的总数
     */
    private int E;
    /**
     * 邻接表
     * 没有实现bag这个结构, 所以用setZ暂时替代
     */
    private Set<DirectedEdge>[] adj;
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Set<DirectedEdge>[])new Set[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<DirectedEdge>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E ++;
    }

    public Set<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Set<DirectedEdge> edges() {
        Set<DirectedEdge> set = new HashSet<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                set.add(e);
            }
        }
        return set;
    }
}
