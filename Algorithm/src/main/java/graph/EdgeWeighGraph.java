package graph;

import java.util.HashSet;
import java.util.Set;

public class EdgeWeighGraph {
    /**
     * 顶点总数
     */
    private int v;
    /**
     * 邻接表
     */
    private Set<Edge>[] adj;

    public EdgeWeighGraph(int v) {
        this.v = v;
        adj = new Set[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new HashSet<>();
        }
    }

    public void addEdge(Edge edge) {
        adj[edge.getV()].add(edge);
        adj[edge.getW()].add(edge);
    }

    public int getV() {
        return v;
    }

    /**
     * 与v相关联的所有边
     * @param v
     * @return
     */
    public Set<Edge> adj(int v) {
        return adj[v];
    }

    /**
     * 图的所有边
     * @return
     */
    public Set<Edge> edges() {
        Set<Edge> edges = new HashSet<>();
        for (int i = 0; i < v; i++) {
            edges.addAll(adj[i]);
        }
        return edges;
    }
}
