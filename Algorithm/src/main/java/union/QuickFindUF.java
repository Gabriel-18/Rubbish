package union;

public class QuickFindUF extends UF {
    /**
     * 构造一个大小为 N 的并查集
     *
     * @param N
     */
    public QuickFindUF(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        for (int i = 0; i < id.length; i ++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
