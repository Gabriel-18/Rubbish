package graph;

import java.util.*;

public class PrimMST extends MST {
    /**
     * 最小生成树的顶点
     */
    private boolean[] marked;
    /**
     * 横切边
     */
    private PriorityQueue<Edge> pq;
    /**
     * 最小生成树的边
     */
    private Set<Edge> mst;

    public PrimMST(EdgeWeighGraph graph) {
        super(graph);

        marked = new boolean[graph.getV()];
        pq = new PriorityQueue<>(Comparator.comparingDouble((Edge o) -> (o.getWeight())));
        mst = new HashSet<>();

        visit(0);

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            int v = edge.getV(), w = edge.getW();

            if (marked[v] && marked[w]) {
                continue;
            }

            mst.add(edge);
            if (!marked[v]) {
                visit(v);
            }
            if (!marked[w]) {
                visit(w);
            }
        }
    }

    @Override
    public Set<Edge> getResult() {
        return mst;
    }

    private void visit(int v) {
        marked[v] = true;

        for (Edge edge : graph.adj(v)) {
            if (!marked[edge.getOther(v)]) {
                pq.add(edge);
            }
        }
    }
}
