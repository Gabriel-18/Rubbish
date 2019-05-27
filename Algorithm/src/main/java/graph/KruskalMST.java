package graph;

import union.QuickFindUF;
import union.UF;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KruskalMST extends MST{
    private Set<Edge> mst;

    public KruskalMST(EdgeWeighGraph graph) {
        super(graph);
        this.mst = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        pq.addAll(graph.edges());

        UF uf = new QuickFindUF(graph.getV());

        while (!pq.isEmpty() && mst.size() < graph.getV() - 1) {
            Edge edge = pq.poll();

            int v = edge.getV(), w = edge.getW();

            if (uf.connected(v, w)) {
                continue;
            }

            uf.connected(v, w);
            mst.add(edge);
        }

    }

    @Override
    public Set<Edge> getResult() {
        return mst;
    }
}
