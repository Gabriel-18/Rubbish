package other;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//已知前序（先序）与中序输出后序：
//前序：1, 2, 3, 4, 5, 6（根左右）
//中序：3, 2, 4, 1, 6, 5（左根右）
//分析：因为前序（根左右）最先出现的总是根结点，所以令root为前序中当前的根结点下标（并且同时把一棵树分为左子树和右子树）。
// start为当前需要打印的子树在中序中的最左边的下标，end为当前需要打印的子树在中序中最右边的下标。
// 递归打印这棵树的后序，递归出口为start > end。
// i为root所表示的值在中序中的下标，所以i即是分隔中序中对应root结点的左子树和右子树的下标。
//先打印左子树，后打印右子树，最后输出当前根结点pre[root]的值。
//输出的后序应该为：3, 4, 2, 6, 5, 1（左右根）

// pre前序 in中序
// debug后依然 搞不清楚的题
public class 重建二叉树 {
    private Map<Integer, Integer> indexForInOrders
            = new HashMap<Integer, Integer>();
    int[] pre = new int[]{3, 9, 20, 15, 7};
    int[] in = new int[]{9, 3, 15, 20, 7};
//    int[] pre = new int[]{3, 9, 20};
//    int[] in = new int[]{9, 3, 20};
    @Test
    public void test() {
        reConstructBinaryTree(pre, in);
    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
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
        TreeNode root = new TreeNode(pre[preL]);
        Integer inIndex = indexForInOrders.get(root.val);
        // 左子树的节点个数
        int leftTreeSize = inIndex - inL;
        // 先序遍历的区间是左子树 preL + 1 preL + numLeft 中序遍历的左子树inL
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        // 先序遍历的区间是左子树 preL + 1 + leftTreeSize preR 中序遍历的左子树inIndex + 1
        root.right = reConstructBinaryTree(pre, preL + 1 + leftTreeSize, preR, inIndex + 1);
        return root;
    }


}
