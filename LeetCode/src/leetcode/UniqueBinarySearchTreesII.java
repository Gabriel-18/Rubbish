package leetcode;

import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    /**
     * https://leetcode.com/problems/unique-binary-search-trees-ii/description/
     * 95. Unique Binary Search Trees II
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        return generateSubtrees(1,n);
    }

    private List<TreeNode> generateSubtrees(int s, int e) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (s > e) {
            res.add(null);
            return res;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> leftSubtrees = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
