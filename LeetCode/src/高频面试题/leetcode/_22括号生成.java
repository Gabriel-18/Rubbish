package 高频面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _22括号生成 {
    List<String> ret = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return ret;
        }

        StringBuilder path = new StringBuilder();
        dfs(path, n, n);
        return ret;
    }


    /**
     * @param path  从根结点到任意结点的路径，全程只使用一份
     * @param left  左括号还有几个可以使用
     * @param right 右括号还有几个可以使用
     */
    private void dfs(StringBuilder path, int left, int right) {
        if (left == 0 && right == 0) {
            // path.toString() 生成了一个新的字符串，相当于做了一次拷贝，这里的做法等同于「力扣」第 46 题、第 39 题
            ret.add(path.toString());
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
        if (left > right) {
            return;
        }

        if (left > 0) {
            path.append("(");
            dfs(path, left - 1, right);
            path.deleteCharAt(path.length() - 1);
        }

        if (right > 0) {
            path.append(")");
            dfs(path, left, right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
