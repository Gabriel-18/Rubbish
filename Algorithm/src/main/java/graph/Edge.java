package graph;

public class Edge {
    /**
     *  顶点之一
     */
    private int v;
    /**
     * 另一个顶点
     */
    private int w;
    /**
     *  权重
     */
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * 使用一个位运算的性质
     * a ^  a = 0;
     * a ^ 0 = a;
     * @param vertex
     * @return
     */
    public int getOther(int vertex) {
        return vertex ^ (v ^ w);
    }
}
