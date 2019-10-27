package other;

public class 二叉搜索树的后序遍历序列 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1) {
            return true;
        }
        // 根节点
        int rootVal = sequence[last];
        int cutIndex = first;
        // 左子树
        while (cutIndex < last && sequence[cutIndex] <= rootVal) {
            cutIndex++;
        }
        // 右子树
        for (int i = cutIndex; i < last; i++) {
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        // 每段都可以继续这样检测下去
        return verify(sequence, first, cutIndex - 1) &&
                verify(sequence, cutIndex, last - 1);
    }
}
