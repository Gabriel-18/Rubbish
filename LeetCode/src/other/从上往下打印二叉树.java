package other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 从上往下打印二叉树 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
                TreeNode t = queue.poll();
                if (t == null) {
                    continue;
                }
                queue.add(t.left);
                queue.add(t.right);
            ret.add(t.val);
        }
        return ret;
    }

    public static void main(String[] args) {
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        boolean add = queue.add(null);
        String s = "abc";
        System.out.println(s.substring(0,s.length()));

    }


}
