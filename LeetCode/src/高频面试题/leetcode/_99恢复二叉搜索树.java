package 高频面试题.leetcode;

import leetcode.TreeNode;

public class _99恢复二叉搜索树 {
    /**
中序遍历过程中，记录错误两个错误排序节点，最后进行交换
只需要中序遍历一遍就可以了

首先我们来看中序遍历过程模板
public void inorder(TreeNode root){
        if (root == null) return ;    //终止条件
        inorder(root.left);           //访问左子树
        对当前节点进行一些操作          //访问根节点-----在遍历过程中希望实现的操作
        inorder(root.right);          //访问右子树
    }

另一方面我们知道 对二叉搜索树进行 中序遍历的时候 访问到的元素是从小到大顺序排列的
如我们对实例 2 恢复好的树 进行中序遍历 得到的应该是  1 2 3 4

那这道题我们就有了大致思路
我们对错误的二叉树进行 中序遍历 那我们按顺序访问到的数应该是按顺序排列的
那如果对两个节点交换了顺序  那一定有两个地方是  不满足  前一个元素 < 当前元素 < 后一个元素
 如示例2      3  1  4   2：
              3  这个节点不满足      1 这个节点不满足
             所以我们使用两个全局变量在遍历过程中记录这两个节点 最后对他们进行交换
 */
    class Solution {
        TreeNode t1, t2, pre;
        public void recoverTree(TreeNode root) {
            inorder(root);
            int temp = t1.val;
            t1.val = t2.val;
            t2.val = temp;
        }
        public void inorder(TreeNode root){
            if (root == null) return ;
            inorder(root.left);
            // 不符合
            if (pre != null && pre.val > root.val) {
                // 第一次记录
                if (t1 == null) {
                    t1 = pre;
                }
                // 更新
                t2 = root;
            }
            // 更新
            pre = root;
            inorder(root.right);
        }
    }
}
