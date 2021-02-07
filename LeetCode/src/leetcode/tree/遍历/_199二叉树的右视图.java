package leetcode.tree.遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            while(cnt-- > 0){
                TreeNode cur = queue.poll();
                // 最保存每层最后一个节点值
                if(cnt == 0){
                    res.add(cur.val);
                }

                if(cur.left != null){
                    queue.add(cur.left);
                }

                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}
