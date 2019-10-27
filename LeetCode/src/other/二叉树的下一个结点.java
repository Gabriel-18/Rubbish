package other;

public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            // 最左节点
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                //
                TreeLinkNode parent = pNode.next;
                // 包含此节点的
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = parent.next;
            }
        }
        return null;
    }
}
