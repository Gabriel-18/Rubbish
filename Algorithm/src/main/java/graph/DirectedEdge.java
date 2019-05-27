package graph;

/**
 * 有向边
 */
public class DirectedEdge {
    /**
     * 边的起点
     */
    private int v;

    /**
     * 边的终点
     */
    private int w;

    /**
     * 边的权重
     */
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f",v,w,weight());
    }
}
