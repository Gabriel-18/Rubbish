package union_find;

public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i =0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //// quick- find
    //private int find(int p) {
    //    return id[p];
    //}
    //
    //// union代价太大 扫描全表
    //public void union(int p, int q) {
    //    int pID = find(p);
    //    int qID = find(q);
    //
    //    if (pID == qID) {
    //        return;
    //    }
    //
    //    for (int i = 0; i < id.length; i++) {
    //        if (id[i] == pID) {
    //            // 重命名
    //            id[i] = qID;
    //        }
    //    }
    //    count --;
    //}

    // quick-union
    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        id[pRoot] = qRoot;
        count --;
    }


}
