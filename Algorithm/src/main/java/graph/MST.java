package graph;

import java.util.Set;

public abstract class MST {
    protected EdgeWeighGraph graph;

    public MST(EdgeWeighGraph graph) {
        this.graph = graph;
    }

    public abstract Set<Edge> getResult();
}
