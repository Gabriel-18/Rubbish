package other;


import java.util.HashMap;
import java.util.Map;



// pre前序 in中序
public class 重建二叉树 {
    private Map<Integer, Integer> indexForInOrders
            = new HashMap<Integer, Integer>();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        Integer inIndex = indexForInOrders.get(root.val);
        // 计算出左边尺寸
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + 1 + leftTreeSize, preR, inL + leftTreeSize + 1);
        return root;
    }


}
