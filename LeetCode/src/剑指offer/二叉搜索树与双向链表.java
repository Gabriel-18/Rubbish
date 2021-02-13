package 剑指offer;

/**
 * 在二叉树中，每个结点都有两个指向子结点的指针。在双向链表中，
 * 每个结点也有两个指针，它们分别指向前一个结点和后一个结点。由于这两种结点的结构相似，
 * 同时二叉搜索树也是一种排序的数据结构，因此在理论上有可能实现二叉搜索树和排序的双向链表的转换。
 * 在搜索二叉树中，左子结点的值总是小于父结点的值，右子结点的值总是大于父结点的值。
 * 因此我们在转换成排序双向链表时，
 * 原先指向左子结点的指针调整为链表中指向前一个结点的指针，
 * 原先指向右子结点的指针调整为链表中指向后一个结点指针。
 * 接下来我们考虑该如何转换。
 * 由于要求转换之后的链表是排好序的，我们可以中序遍历树中的每一个结点，
 * 这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每一个结点。
 * 当遍历到根结点的时候，我们把树看成三部分：
 * 值为 10 的结点、根结点值为 6 的左子树、根结点值为 14 的右子树。
 * 根据排序链表的定义，值为 10 的结点将和它的左子树的最大一个结点（即值为 8 的结点）链接起来，
 * 同时它还将和右子树最小的结点（即值为 12 的结点）链接起来，如图 4.13 所示。
 */
public class 二叉搜索树与双向链表 {
    private TreeNode pre = null;
    private TreeNode head = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        // 保证首尾相连
        head.left = pre;
        pre.right = head;
        inOrder(pRootOfTree);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 处理左子树
        inOrder(node.left);

        if (head == null) {
            head = node;
        }
        /**
         * 核心代码逻辑
         */
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;


        // 处理右子树
        inOrder(node.right);
    }
}
