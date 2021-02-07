package 剑指offer.tree;



public class 二叉树的下一个结点 {


    //public class TreeLinkNode {
    //
    //    int val;
    //    TreeLinkNode left = null;
    //    TreeLinkNode right = null;
    //    TreeLinkNode next = null; // 指向父结点的指针
    //
    //    TreeLinkNode(int val) {
    //        this.val = val;
    //    }
    //}
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 当当前节点的的右子树不为空时
        if (pNode.right != null) {
            // 获取右子树节点
            TreeLinkNode node = pNode.right;
            // 先找到最左节点
            while (node.left != null) {
                node = node.left;
            }
            // 返回最左节点
            return node;
        } else {
            while (pNode.next != null) {
                // 当前节点的父节点
                TreeLinkNode parent = pNode.next;
                // 如果父节点的左链接 和 当前节点 相同
                // 则表明找到了
                if (parent.left == pNode) {
                    return parent;
                }
                // 向上更新当前节点
                pNode = pNode.next;
            }
        }
        return null;
    }
}
