package other;

import org.junit.Test;

// root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
public class 树中两个节点的最低公共祖先 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);




        root.left.right.left = new TreeNode(3);
        TreeNode left = root.left;
        root.left.right.right = new TreeNode(5);
        TreeNode right = root.left.right;

        lowestCommonAncestor(root,left,right);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);




        root.left.right.left = new TreeNode(7);
        TreeNode left = root.left;
        root.left.right.right = new TreeNode(4);
        TreeNode right = root.right;

        lowestCommonAncestor2(root,left,right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null || root == p || root == q)
//            return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }


}
