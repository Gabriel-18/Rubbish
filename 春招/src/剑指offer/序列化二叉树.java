package 剑指offer;

public class 序列化二叉树 {
    private String deserializeStr;
    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String res = "";
        // 前序遍历
        res += root.val;
        res += " ";
        res += Serialize(root.left);
        res += " ";
        res += Serialize(root.right);
        return res;
//        return root.val + " " +
//                Serialize(root.left) + " " +
//                Serialize(root.right);
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
        // 没有空格的话 说明是最后一个字符
        // 有空格的话 直接从0开始来截取 index是没有被包括的
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        // 下一次需要处理的字符串
        // 更新字符串
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        // #代表此处为空
        if (node.equals("#")) {
            return null;
        }
        //
        Integer val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

}
