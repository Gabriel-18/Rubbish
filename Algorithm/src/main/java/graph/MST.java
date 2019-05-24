package graph;

import java.util.Set;

public abstract class MST {
    protected EdgeWeightGraph graph;

    public MST(EdgeWeightGraph graph) {
        this.graph = graph;
    }

    public abstract Set<Edge> getResult();
}
