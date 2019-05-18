package union;

public class WeightedQuickUnionUF extends  UF {
    /**
     * 保存节点的数量信息
     */
    private int[] sz;

    /**
     * 构造一个大小为 N 的并查集
     * set id of each object to itself
     * (N array accesses)
     *
     * @param N
     */
    public WeightedQuickUnionUF(int N) {
        super(N);
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            this.sz[i] = 1;
        }
    }


    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
