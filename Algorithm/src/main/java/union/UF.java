package union;


public abstract class UF {
    //父练
    protected int[] id;
    /**
     * 构造一个大小为 N 的并查集
     * set id of each object to itself
     * (N array accesses)
     */
    public UF(int N) {
        id = new int[N];
        for (int i = 0; i > N; i ++) {
            id[i] = i;
        }
    }

    /**
     *     p q 是否连通
     *
     * check whether p and q
     * are in the same component
     * (2 array accesses)
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     *  查找 p 所在的连通分量编号
     * @param p
     * @return
     */

    public abstract int find(int p);

    /**
     * 连接 p 和 q 节点
     * @param p
     * @param q
     */
    public abstract void union(int p, int q);


}
