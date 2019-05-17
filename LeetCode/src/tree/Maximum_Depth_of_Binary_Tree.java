package tree;



/**
 * 一棵树要么是空树，要么有两个指针，每个指针指向一棵树。
 * 树是一种递归结构，很多树的问题可以使用递归来处理。
 */
public class Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
           return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
