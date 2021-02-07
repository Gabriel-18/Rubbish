package 剑指offer.tree;




import java.util.HashMap;
import java.util.Map;


// pre前序 in中序
// debug后依然 搞不清楚的题
// 前序第一个值 将中序遍历分成两部分
// 左边为左子树中的中序遍历结果 右边为右子树中的中序遍历结果

// 问题在于 如何获取 划分后的左子树 和 右子树的区间
// 不好描述
public class 重建二叉树 {
    // Hashmap无序
    private Map<Integer, Integer> indexForInOrders = new HashMap<Integer, Integer>();


    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 记录中序的位置
        // 方便定位
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }


    // 中序序列的中root 将序列划分成左子树 右子树
    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        // 当符合这个条件时 显然当前二叉树不存在了
        // 先序序列长度小于等于0 直接返回
        if (preL > preR) {
            return null;
        }
        // 当前树的根节点
        TreeNode root = new TreeNode(pre[preL]);
        // 获取root所在中序的索引
        Integer inIndex = indexForInOrders.get(root.val);
        // 左子树的大小
        int leftTreeSize = inIndex - inL;
        // 先序遍历的区间是左子树 preL + 1 preL + numLeft 中序遍历的左子树inL
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        // 先序遍历的区间是左子树 preL + 1 + leftTreeSize preR 中序遍历的左子树inIndex + 1
        root.right = reConstructBinaryTree(pre, preL + 1 + leftTreeSize, preR, inIndex + 1);
        return root;
    }


}
