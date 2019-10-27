package other;

public class 序列化二叉树 {
    private String deserializeStr;
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        // 前序遍历
        return root.val + " " +
                Serialize(root.left) + " " +
                Serialize(root.right);
    }
    TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        // 下一次需要处理的字符串
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#")) {
            return null;
        }
        Integer val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

}
